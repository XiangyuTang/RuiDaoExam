package com.neuedu.ruidaoexam.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.neuedu.ruidaoexam.entity.AnsweredQuestion;

public interface AnsweredQuestionService {
	
	//@CacheEvict 注解表示当执行如下方法时,会删除redis中key为userlist的对象,这样保证数据的正确性,
	//下一次再查询时,把最新的userlist重新加载到redis中,保证了数据的及时显示的特性
	//allEntries=true 表示会删除userlist对象中所有的数据
	//beforeInvocation=true 表示无论该方法是否会抛出异常亦或执行成功,都会在执行该方法之前把缓存对象userlist清理掉
	@CacheEvict(value="updateQues", allEntries=true,beforeInvocation=true)
	int update(AnsweredQuestion aq);
	
	int selectPrimeKey(AnsweredQuestion aq);
	
	@CacheEvict(value="acquired_score",beforeInvocation=true)
	int selectScores(int paper_result_id);
}
