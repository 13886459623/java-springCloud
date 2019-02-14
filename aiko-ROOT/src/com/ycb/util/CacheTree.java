package com.ycb.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CacheTree<T> implements java.io.Serializable {
	private static final long serialVersionUID = 3159940785359195180L;
	private String idFieldName;
	private String parentIdFieldName;
	private String sortFieldName;
	private String topNodeId = "0";
	private Map<String, TObj> map;
	private List<TObj> firstChilds;

	public CacheTree(String idFieldName, String parentIdFieldName, String sortFieldName, List<T> ls) {
		this(idFieldName, parentIdFieldName, sortFieldName, ls, "0");
	}

	public CacheTree(String idFieldName, String parentIdFieldName, String sortFieldName, List<T> ls, String topNodeId) {
		this.idFieldName = idFieldName;
		this.parentIdFieldName = parentIdFieldName;
		this.sortFieldName = sortFieldName;
		if (topNodeId != null) {
			this.topNodeId = topNodeId;
		}
		int size = (ls == null ? 0 : ls.size());
		this.map = new HashMap<String, TObj>(size);
		if (size > 0) {
			this.firstChilds = new ArrayList<TObj>();
			init(ls);
		}
	}

	public T get(String id) {
		TObj tobj = this.map.get(id);
		return tobj == null ? null : tobj.obj;
	}

	public boolean contains(String id) {
		return this.map.containsKey(id);
	}

	public T getParent(String id) {
		TObj tobj = this.map.get(id);
		if (tobj != null) {
			tobj = this.map.get(tobj.pid);
		}
		return tobj == null ? null : tobj.obj;
	}

	public List<T> getParents(String id, boolean containSelf) {
		List<T> rsList = new ArrayList<T>();
		TObj tobj = this.map.get(id);
		if (tobj != null) {
			if (containSelf) {
				rsList.add(tobj.obj);
			}
			tobj = this.map.get(tobj.pid);
			while (tobj != null) {
				rsList.add(tobj.obj);
				tobj = this.map.get(tobj.pid);
			}
			Collections.reverse(rsList);
		}
		return rsList;
	}

	public List<T> getChilds(String id) {
		TObj tobj = this.map.get(id);
		return tobj == null ? srcList(this.firstChilds, true) : srcList(tobj.childs, true);
	}

	public boolean hasChilds(String id) {
		TObj tobj = this.map.get(id);
		return tobj == null || tobj.childs == null || tobj.childs.size() == 0 ? false : true;
	}

	private List<T> srcList(List<TObj> ls, boolean asc) {
		int len = (ls == null ? 0 : ls.size());
		List<T> rsList = new ArrayList<T>(len);
		if (asc) {
			for (int i = 0; i < len; i++) {
				rsList.add(ls.get(i).obj);
			}
		} else {
			for (int i = len - 1; i >= 0; i--) {
				rsList.add(ls.get(i).obj);
			}
		}
		return rsList;
	}

	public List<T> getTree() {
		return getTree(this.topNodeId, true, true);
	}

	public List<T> getTree(String id) {
		return getTree(id, true, true);
	}

	public List<T> getTree(String id, boolean containSelf, boolean asc) {
		List<T> rsList = new ArrayList<T>();
		List<TObj> ls = null;
		if (this.topNodeId.equals(id)) {
			ls = this.firstChilds;
		} else {
			TObj tobj = this.map.get(id);
			if (tobj != null) {
				if (containSelf) {
					rsList.add(tobj.obj);
				}
				ls = tobj.childs;
			}
		}
		int len = (ls == null ? 0 : ls.size());
		if (asc) {
			for (int i = 0; i < len; i++) {
				getTree(rsList, ls.get(i), asc);
			}
		} else {
			for (int i = len - 1; i >= 0; i--) {
				getTree(rsList, ls.get(i), asc);
			}
		}
		return rsList;
	}

	private List<T> getTree(List<T> rsList, TObj tobj, boolean asc) {
		rsList.add(tobj.obj);

		List<TObj> ls = tobj.childs;

		int len = ls == null ? 0 : ls.size();
		if (asc) {
			for (int i = 0; i < len; i++) {
				getTree(rsList, ls.get(i), asc);
			}
		} else {
			for (int i = len - 1; i >= 0; i--) {
				getTree(rsList, ls.get(i), asc);
			}
		}
		return rsList;
	}

	public Map<String, String> getTreeMap(String head, String node, String keyField, String valueField, int[] levels, boolean asc) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		int len = this.firstChilds == null ? 0 : this.firstChilds.size();
		if (len <= 0) {
			return map;
		}
		TObj tobj = null;
		TField key = null;
		TField value = null;
		if (asc) {
			for (int i = 0; i < len; i++) {
				tobj = this.firstChilds.get(i);
				if (key == null) {
					Class<?> clazz = tobj.obj.getClass();
					key = new TField(clazz, keyField);
					value = new TField(clazz, valueField);
				}
				getTreeMap(map, tobj, 1, head, node, key, value, levels, asc);
			}
		} else {
			for (int i = len - 1; i >= 0; i--) {
				tobj = this.firstChilds.get(i);
				if (key == null) {
					Class<?> clazz = tobj.obj.getClass();
					key = new TField(clazz, keyField);
					value = new TField(clazz, valueField);
				}
				getTreeMap(map, tobj, 1, head, node, key, value, levels, asc);
			}
		}
		return map;
	}
	
	public void setChilds(String id, String childsField) {
		if(topNodeId.equals(id)){
			int size = firstChilds == null ? 0 : firstChilds.size();
			for (int i = 0; i < size; i++) {
				setChilds(firstChilds.get(i).id, childsField);
			}
		} else {
			TObj tobj = map.get(id);
			if (tobj != null && tobj.childs.size() > 0) {
				int size = tobj.childs.size();
				List<T> ls = new ArrayList<T>(size);
				for (int i = 0; i < size; i++) {
					ls.add(tobj.childs.get(i).obj);
					setChilds(tobj.childs.get(i).id, childsField);
				}
				setFieldValue(tobj.obj, childsField, ls);
			}
		}
	}

	private void getTreeMap(Map<String, String> map, TObj tobj, int level, String head, String node, TField key,
			TField value, int[] levels, boolean asc) {
		boolean flag = false;
		if (levels == null || levels.length == 0) {
			flag = true;
		} else {
			for (int i = 0; i < levels.length; i++) {
				if (level == levels[i]) {
					flag = true;
					break;
				}
			}
		}
		if (flag) {
			StringBuilder sbd = new StringBuilder();
			if (level > 1) {
				if (head != null) {
					sbd.append(head);
				}
				for (int i = 0; i < level - 1; i++) {
					sbd.append(node);
				}
			}
			sbd.append(value.getValue(tobj.obj));
			map.put(String.valueOf(key.getValue(tobj.obj)), sbd.toString());
		}
		int len = tobj.childs == null ? 0 : tobj.childs.size();
		for (int i = len - 1; i >= 0; i--) {
			getTreeMap(map, tobj.childs.get(i), level + 1, head, node, key, value, levels, asc);
		}
	}

	private void init(List<T> ls) {
		T obj = null;
		for (int i = 0, len = (ls == null ? 0 : ls.size()); i < len; i++) {
			obj = ls.get(i);
			if (obj != null) {
				TObj tobj = new TObj(obj, getFieldValue(obj, idFieldName), getFieldValue(obj, parentIdFieldName),
						getFieldValue(obj, sortFieldName));
				if (tobj.id != null) {
					map.put(tobj.id, tobj);
				}
			}
		}

		for (Iterator<Map.Entry<String, TObj>> iter = this.map.entrySet().iterator(); iter.hasNext();) {
			findFather(iter.next().getValue());
		}

		for (int i = 0, len = (this.firstChilds == null ? 0 : this.firstChilds.size()); i < len; i++) {
			sort(this.firstChilds.get(i));
		}
		this.firstChilds = sort(this.firstChilds);
	}

	private void findFather(TObj tobj) {
		if (!tobj.flag) {
			TObj pobj = this.map.get(tobj.pid);
			if (pobj != null) {
				pobj.childs.add(tobj);
				findFather(pobj);
			} else {
				this.firstChilds.add(tobj);
			}
			tobj.flag = true;
		}
	}

	private void sort(TObj tobj) {
		for (int i = 0, len = tobj.childs.size(); i < len; i++) {
			sort(tobj.childs.get(i));
		}
		tobj.childs = sort(tobj.childs);
	}

	private List<TObj> sort(List<TObj> ls) {
		if (ls != null && ls.size() > 0) {
			@SuppressWarnings("unchecked")
			TObj[] objs = new CacheTree.TObj[ls.size()];
			objs = (TObj[]) ls.toArray(objs);
			TObj objA = null;
			TObj objB = null;
			TObj objC = null;
			for (int i = 0; i < objs.length - 1; i++) {
				for (int j = i + 1; j < objs.length; j++) {
					objA = objs[i];
					objB = objs[j];
					if (objA.sort > objB.sort) {
						objC = objs[j];
						objs[j] = objs[i];
						objs[i] = objC;
					}
				}
			}
			ls = Arrays.asList(objs);
		}
		return ls;
	}

	private Object getFieldValue(Object obj, String fieldName) {
		Class<?> clazz = obj.getClass();
		try {
			if(obj instanceof java.util.Map){
				Map<?, ?> map = (Map<?, ?>)obj;
				return map.get(fieldName);
			} else {
				try {
					Method method = clazz.getMethod(getter(fieldName));
					method.setAccessible(true);
					return method.invoke(obj, (Object[]) null);
				} catch (NoSuchMethodException nme) {
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					return field.get(obj);
				}
			}
		} catch (Throwable e) {
			throw new RuntimeException("Unable to get the field[" + fieldName + "] value from the class[" + clazz.getCanonicalName() + "]");
		}
	}
	
	private void setFieldValue(Object obj, String fieldName, Object fieldValue) {
		Class<?> clazz = obj.getClass();
		try {
			if(obj instanceof java.util.Map){
				@SuppressWarnings("unchecked")
				Map<Object, Object> map = (Map<Object, Object>)obj;
				map.put(fieldName, fieldValue);
			} else {
				try {
					Method method = clazz.getMethod(setter(fieldName));
					method.setAccessible(true);
					method.invoke(obj, new Object[]{fieldValue});
				} catch (NoSuchMethodException nme) {
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(obj, fieldValue);
				}
			}
		} catch (Throwable e) {
			throw new RuntimeException("Unable to set the field[" + fieldName + "] value to the class[" + clazz.getCanonicalName() + "]");
		}
	}

	private class TField {
		private String fieldName = null;
		private Class<?> clazz = null;
		private Field field = null;
		private Method method = null;

		private TField(Class<?> clazz, String fieldName) {
			/*
			 * just care this class field and method
			 */
			this.clazz = clazz;
			this.fieldName = fieldName;
			String methodName = getter(fieldName);
			try {
				method = clazz.getMethod(getter(fieldName));
				method.setAccessible(true);
			} catch (NoSuchMethodException nme) {
				try {
					field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
				} catch (NoSuchFieldException nfe) {
					throw new RuntimeException("Unable to find the field[" + fieldName + "] or the getter[" + methodName + "] from the class[" + clazz.getCanonicalName() + "]");
				}
			}
		}

		private Object getValue(Object obj) {
			try {
				return getFieldValue(obj, this.fieldName);
			} catch (Throwable e) {
				throw new RuntimeException("Unable to get the field[" + fieldName + "] value from the class[" + clazz.getCanonicalName() + "]");
			}
		}

	}

	private String getter(String fieldName) {
		StringBuilder methodName = new StringBuilder(3 + fieldName.length());
		methodName.append("get");
		char chs[] = fieldName.toCharArray();
		chs[0] = Character.toUpperCase(chs[0]);
		methodName.append(chs);
		return methodName.toString();
	}
	
	private String setter(String fieldName) {
		StringBuilder methodName = new StringBuilder(3 + fieldName.length());
		methodName.append("set");
		char chs[] = fieldName.toCharArray();
		chs[0] = Character.toUpperCase(chs[0]);
		methodName.append(chs);
		return methodName.toString();
	}

	private class TObj implements java.io.Serializable {
		private static final long serialVersionUID = 3141884722173818979L;
		private String id;
		private String pid;
		private long sort;
		private boolean flag;
		private T obj;
		private List<TObj> childs = new ArrayList<TObj>();

		private TObj(T obj, Object id, Object pid, Object sort) {
			this.obj = obj;
			if (id != null) {
				this.id = id.toString();
			}
			if (pid != null) {
				this.pid = pid.toString();
			}
			if (sort != null) {
				if (sort instanceof Integer) {
					this.sort = ((Integer) sort).longValue();
				} else if (sort instanceof Long) {
					this.sort = ((Long) sort).longValue();
				} else {
					this.sort = (long) sort.toString().hashCode();
				}
			}
		}
	}
	
}
