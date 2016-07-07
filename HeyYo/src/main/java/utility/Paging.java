package utility;

public class Paging {//����¡ ���� ����	
	private int totalCount = 0 ; //�� ���ڵ� �Ǽ�
	private int totalPage = 0 ; //��ü ������ ��
	private int pageNumber = 0 ; //������ ������ �ѹ�(ǥ�� ������ �������� 1���� totalPage�����̴�.)
	private int pageSize = 0 ; //�� �������� ������ �Ǽ�
	private int beginRow = 0 ; //���� �������� ���� ��
	private int endRow = 0 ; //���� �������� �� ��
	private int pageCount = 10 ; //������ ������ ��ũ ��
	private int beginPage = 0 ; //����¡ ó�� ���� ������ ��ȣ
	private int endPage = 0 ; //����¡ ó�� �� ������ ��ȣ
	private int offset = 0 ;
	private int limit = 0 ;
	private String url = "" ; 
	private String pagingHtml = "";//�ϴ��� ���� ������ ��ũ
	private String pagingStatus = ""; //��� ������ ���� ������ ��ġ ǥ��
	//�˻��� ���� ���� �߰�
	private String whatColumn = "" ; //�˻� ���(�ۼ���, ������, ��ü �˻��� all) ���
	private String keyword = "" ; //�˻��� �ܾ� 

	public Paging(
			String _pageNumber, 
			String _pageSize,  
			int totalCount,
			String url, 
			String whatColumn, 
			String keyword,
			String whologin) {		

		if( _pageNumber == null || _pageNumber.equals("null") || _pageNumber.equals("") ){
			_pageNumber = "1" ;
		}
		this.pageNumber = Integer.parseInt( _pageNumber ) ; 
		
		if( _pageSize == null || _pageSize.equals("null") || _pageSize.equals("") ){
			_pageSize = "5" ;
		}		
		this.pageSize = Integer.parseInt( _pageSize ) ;
		
		this.offset = ( pageNumber - 1 ) * pageSize ;
		this.limit = pageSize ;
		
		this.totalCount = totalCount ; 
		
		this.totalPage = (int)Math.ceil((double)this.totalCount / this.pageSize) ;
		
		this.beginRow = ( this.pageNumber - 1 )  * this.pageSize  + 1 ;
		this.endRow =  this.pageNumber * this.pageSize ;
		
		if( this.endRow > this.totalCount ){
			this.endRow = this.totalCount  ;
		}
		
		this.beginPage = ( this.pageNumber - 1 ) / this.pageCount * this.pageCount + 1  ;
		this.endPage = this.beginPage + this.pageCount - 1 ;
		
		if( this.endPage > this.totalPage ){
			 this.endPage = this.totalPage ;
		}
		
		this.url = url ;
		this.whatColumn = whatColumn ;
		this.keyword = keyword ;
		
		this.pagingHtml = getPagingHtml(url) ;
		this.pagingStatus = "�� " + this.totalCount 
				+ "��[" + this.pageNumber + "/" + this.totalPage + "]" ; 
		
	}

	private String getPagingHtml( String url ){ //����¡ ���ڿ��� �����.
		String result = "<nav><ul class='pagination'>" ;
		String added_param = "&whatColumn=" + whatColumn + "&keyword=" + keyword ; 
		
		if (this.beginPage != 1) { 
			result += "<li><a href='" + url  
					+ "?pageNumber=" + ( 1 ) + "&pageSize=" + this.pageSize + "' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>" ;
			result += "<li><a href='" + url 
					+ "?pageNumber=" + (this.beginPage - 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>&lsaquo;</a></li>" ;
		}
		
		
		for (int i = this.beginPage; i <= this.endPage ; i++) {
			if ( i == this.pageNumber ) {
				result += "<li class='active'><a href='#'>" + i + "</a></li>"	;
						
			} else {
				result += "<li><a href='" + url   
						+ "?pageNumber=" + i + "&pageSize=" + this.pageSize 
						+ added_param + "'>" + i + "</a></li>" ;
			}
		}
		
		if ( this.endPage != this.totalPage) {
			result += "<li><a href='" + url  
					+ "?pageNumber=" + (this.endPage + 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>&rsaquo;</a></li>" ;
			
			result += "<li><a href='" + url  
					+ "?pageNumber=" + (this.totalPage ) + "&pageSize=" + this.pageSize 
					+ added_param + "'><span aria-hidden='true'>&raquo;</span></a></li></ul></nav>;" ;
		}		
		
		return result ;
	}	

	
	public String getPagingHtml() {	return pagingHtml;}
	public int getPageNumber() {	return pageNumber;}
	public int getPageSize() {	return pageSize;}	
	public String getPagingStatus() {	return pagingStatus;}	
	public int getBeginRow() {	return beginRow;}
	public int getEndRow() {	return endRow;}
	public int getOffset() {	return offset; }
	public int getLimit() {	return limit;	}	
}