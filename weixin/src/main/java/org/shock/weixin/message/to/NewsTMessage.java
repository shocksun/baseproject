package org.shock.weixin.message.to;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class NewsTMessage extends TMessage{


	private List<Item> Articles = Lists.newArrayList();
	private Integer ArticleCount;
	
	public NewsTMessage() {
		super("news");
	}

	public void addItem(Item item){
		if(Articles.size()<=8){
			Articles.add(item);
		}
		ArticleCount=Articles.size();
	}

}
