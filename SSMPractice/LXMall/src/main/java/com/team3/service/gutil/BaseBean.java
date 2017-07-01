package com.team3.service.gutil;

	/**
	 * 所有的实体的父类
	 * @author 刘宇内
	 *
	 */
	public class BaseBean {
	    /**
	     * 查询起始的记录数
	     */
		private long start;
		/**
	   * 每页显示的条数
		 */
	 private long length=8;
	   public long getStart() {
			return start;
		}
		public void setStart(long start) {
			this.start = start;
		}
		public long getLength() {
			return length;
		}
		public void setLength(long length) {
			this.length = length;
		}

}
