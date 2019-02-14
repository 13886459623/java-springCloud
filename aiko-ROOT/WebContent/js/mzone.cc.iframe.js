/**
 * Title   : iframe�߶��Զ���������Ӧ�����������IE��Firefox��Chrome�ȣ�.��Ҫע�������chrome�²���ʱ������web�����в���
 * Author  : ��ľ����
 * Site    : http://www.mzone.cc
 * Date    : 2010-10-14
 * Version : 0.1
 */

/**
 * Desc   : ����mzone.cc.iframe����
 */
mzone.createObject("mzone.cc.iframe");

/**
 * Desc   : �������mzone.cc.iframe�ľ�̬����ʵ��iframe��̬����
 * Para   : iframe - Ҫ������iframe����DOM����
 *          extHeight - �Զ�����iframe�ĸ߶Ⱥ�������ӵĸ߶�ֵ��������
 *          minHeight - iframe����С�߶ȣ�������
 * Return : û�з���ֵ
 */
mzone.cc.iframe.autoHeight = function(/*object*/iframe, /*int*/extHeight, /*int*/minHeight) {
	iframe.style.display = "block";
	if (iframe.contentDocument && iframe.contentDocument.body.offsetHeight) { // ff,chrome��
		var h = parseInt(iframe.contentDocument.body.offsetHeight) + 50;
		h += extHeight;
		if (h < minHeight) h = minHeight;
		iframe.height = h + "px";
	} else if (iframe.Document && iframe.Document.body.scrollHeight) { // IE
		var h = parseInt(iframe.Document.body.scrollHeight) + 35;
		h += extHeight;
		if (h < minHeight) h = minHeight;
		iframe.height = h + "px";
	} else {
		var h = parseInt(iframe.contentWindow.document.documentElement.scrollHeight) + 35;
		h += extHeight;
		if (h < minHeight) h = minHeight;
		iframe.height = h + "px";
	}
}