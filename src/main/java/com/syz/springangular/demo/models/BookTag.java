package com.syz.springangular.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BookTag")
public class BookTag {
	@Id
	private String tagName;
	private int count;
	
	public BookTag(String tagName, Integer count) {
		super();
		this.tagName = tagName;
		this.count = count;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getCount() {
		return count;
	}

	public void add() {
		this.count++;
	}

	@Override
	public String toString() {
		return "BookTag [tagName=" + tagName + ", count=" + count + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true   
        if (obj == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(obj instanceof BookTag)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        BookTag bookTag = (BookTag) obj; 
          
        // Compare the data members and return accordingly  
        return bookTag.getTagName().equalsIgnoreCase(this.tagName); 
	}
	
	
	
	
	
	
	
	

}
