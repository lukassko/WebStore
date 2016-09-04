package com.app.store.utility;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

public class PaginationResult<E> {

	private int totalRecords;
	private int currentPage;
	private int page;
	private List<E> resultList;
	private int maxResult;
	private int totalPages;
	private int maxNavigationPage;
	private List<Integer> navigationPage;
	
	@SuppressWarnings("unchecked")
	public PaginationResult(Query query, int page, int maxResult, int maxNavogationPage){
		
		int pageIndex = (page - 1 < 0 ? 0 : page - 1);
		int fromRecordIndex = pageIndex * maxResult;
		int maxRecordIndex = fromRecordIndex + maxResult;
		ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
		
		List<E> results = new ArrayList<E>();
		
		boolean hasResult = resultScroll.first();
		
		if (hasResult) {
			hasResult = resultScroll.scroll(fromRecordIndex);
			
			if (hasResult) {
				do {
					E record = (E) resultScroll.get(0);
	                results.add(record);
				} while (resultScroll.next()
	                       && resultScroll.getRowNumber() >= fromRecordIndex
	                       && resultScroll.getRowNumber() < maxRecordIndex);	
				
				resultScroll.last();
			}
		}	
		this.totalRecords = resultScroll.getRowNumber();
		this.currentPage = pageIndex+1;
		this.resultList = results;
		this.maxResult = maxResult;
		this.totalPages = (this.totalRecords/this.maxResult) + 1;
		this.maxNavigationPage = maxNavogationPage;
		if (maxNavogationPage < totalPages) {
			this.maxNavigationPage = totalPages;
		}
		calcNavigationPage();
	}
	
	private void calcNavigationPage () {
		navigationPage = new ArrayList<Integer>();

	    int current = this.currentPage > this.totalPages ? this.totalPages : this.currentPage;
	 
	    int begin = current - this.maxNavigationPage / 2;
	    int end = current + this.maxNavigationPage / 2;
	       // First page
	    navigationPage.add(1);
	    if (begin > 2) {
	        // For '...'
	       navigationPage.add(-1);
	    }
	 
	    for (int i = begin; i < end; i++) {
	        if (i > 1 && i < this.totalPages) {
	      	   navigationPage.add(i);
	        }
	    }
	 
	    if (end < this.totalPages - 2) {
	        // For '...'
	       navigationPage.add(-1);
	    }
	    // Last page.
	    navigationPage.add(this.totalPages);
	    
	}
	
	public int getTotalPages() {
	    return totalPages;
	}
	
	public int getTotalRecords() {
	    return totalRecords;
	}
	 
	public int getCurrentPage() {
	    return currentPage;
	}
	
	public List<E> getResultList() {
	    return resultList;
	}
	 
	public int getMaxResult() {
	   return maxResult;
	}
	 
	public List<Integer> getNavigationPage() {
	    return navigationPage;
	}
}
