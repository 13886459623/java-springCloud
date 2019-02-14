package chinapay.util;

/**
 * 
 * @项目名称: --
 * @版权所有: --
 * @技术支持: --
 * @单元名称: 分页实体类
 * @开发人员: --
 */
public class Page {
 
	private Integer currentPage = 1;// 当前页
 
	private Integer pageSize = 10;// 每页量
 
	private String orderField;// 排序字段，多个字段用","隔开
 
	private String sort = "DESC";// 排序方式，DESC降序；ASC升序
 
	private Integer start;// 分页开始记录条数
 
	private Long totalRecord;// 总记录数
 
	private Integer totalPage;// 总页数
 
	public Integer getCurrentPage() {
		return currentPage;
	}
 
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
 
	public Integer getPageSize() {
		return pageSize;
	}
 
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
 
	public String getOrderField() {
		return orderField;
	}
 
	public void setOrderField(String orderField) {
		this.orderField = orderField == null ? null : orderField.trim();
	}
 
	public String getSort() {
		return sort;
	}
 
	public void setSort(String sort) {
		this.sort = sort == null ? null : sort.trim();
	}
 
	public Integer getStart() {
		return start;
	}
 
	public void setStart(Integer start) {
		this.start = start;
	}
 
	public Long getTotalRecord() {
		return totalRecord;
	}
 
	public void setTotalRecord(Long totalRecord) {
		if (totalRecord != null) {
			this.start = (this.currentPage - 1) * this.pageSize;
 
			this.totalPage = (int) ((totalRecord % this.pageSize) == 0 ? (totalRecord / this.pageSize)
					: (totalRecord / this.pageSize) + 1);
		}
		this.totalRecord = totalRecord;
	}
 
	public Integer getTotalPage() {
		return totalPage;
	}
 
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * 
	 * 根据页数 和 每页显示量 计算limit 所需参数
	 * @param page
	 * @param size
	 */
	public void setPageAndSize(Integer currentPage,Integer pageSize) {
		if(currentPage>0) {
			this.currentPage =(currentPage-1)*pageSize;
			this.pageSize =pageSize;
		}else if(currentPage==0) {
			this.currentPage =currentPage;
			this.pageSize =pageSize;
		}
			
	}
	
 
}
