package com.project.heyyo.content.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myContentDao")
public class ContentDao {
	private final String namespace = "com.project.heyyo.content.model.Content";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<Content> getAllContent(Map<String, String> map) {
		List<Content> lists = new ArrayList<Content>();
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetAllContent", map);

		return lists;
	}

	public Content getContentByNum(int num) {
		Content content;
		content = sqlSessionTemplate.selectOne(namespace + ".GetContentByNum",
				num);
		return content;
	}

	public void insertTalentData(Content content) {

		sqlSessionTemplate.insert(namespace + ".InsertTalentData", content);
	}

	public int GetTotalCount(Map<String, String> map) {
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		return cnt;
	}

	public List<Content> getAllContentList(Paging pageInfo, Map<String, String> map) {
		List<Content> lists = new ArrayList<Content>();
		RowBounds rowBounds = 
				new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		lists = sqlSessionTemplate
				.selectList(namespace + ".GetAllContentList", map, rowBounds);

		return lists;
	}
	
	public int getNumberById(int id){
		int num;
		num = sqlSessionTemplate.selectOne(namespace+".GetNumberById",id);
		return num;
	}
	
	//정보수정
		public void modifyContent(Content content){
			sqlSessionTemplate.update(namespace + ".UpdateContent", content);
		}
		//글 삭제
		public void deleteContent(int num){
			sqlSessionTemplate.delete(namespace + ".DeleteContent", num);
		}

}
