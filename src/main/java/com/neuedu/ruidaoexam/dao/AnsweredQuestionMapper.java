package com.neuedu.ruidaoexam.dao;

import com.neuedu.ruidaoexam.entity.AnsweredQuestion;
import com.neuedu.ruidaoexam.entity.AnsweredQuestionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AnsweredQuestionMapper {
    int countByExample(AnsweredQuestionExample example);

    int deleteByExample(AnsweredQuestionExample example);

    int deleteByPrimaryKey(Integer answerId);

    int insert(AnsweredQuestion record);

    int insertSelective(AnsweredQuestion record);

    List<AnsweredQuestion> selectByExample(AnsweredQuestionExample example);

    AnsweredQuestion selectByPrimaryKey(Integer answerId);

    int updateByExampleSelective(@Param("record") AnsweredQuestion record, @Param("example") AnsweredQuestionExample example);

    int updateByExample(@Param("record") AnsweredQuestion record, @Param("example") AnsweredQuestionExample example);

    int updateByPrimaryKeySelective(AnsweredQuestion record);

    int updateByPrimaryKey(AnsweredQuestion record);
    
    List<AnsweredQuestion> selectAllByAnsPaperId(int ans_paper_id);
    
    AnsweredQuestion selectByPaperResultId(Integer paperResultId);	//根据paper_result_id取*
    
    Integer sumKeGuanTiScore(Integer paperResultId);	//根据paper_result_id和ques_type(1,2,4)取客观题实际得分
    Integer sumKeGuanTiTotalScore(Integer paperResultId);	//根据paper_result_id和ques_type(1,2,4)取客观题总得分
    
    Integer sumZhuGuanTiScore(Integer paperResultId);	//根据paper_result_id和ques_type(3,5)取主观题实际得分
    Integer sumZhuGuanTiTotalScore(Integer paperResultId);	//根据paper_result_id和ques_type(3,5)取主观题总得分
    
    Integer countKeGuanTiNum(Integer paperResultId);	//根据paper_result_id和ques_type(1,2,4)取客观题数目
    Integer countZhuGuanTiNum(Integer paperResultId);	//根据paper_result_id和ques_type(3,5)取主观题数目
    
    Integer sumXuanZeTiScore(Integer paperResultId);	//根据paper_result_id和ques_type(1,2)取选择题实际得分
    Integer countXuanZeTiNum(Integer paperResultId);	//根据paper_result_id和ques_type(1,2)取选择题数目
    Integer countXuanZeTiWrongNum(Integer paperResultId);	//根据paper_result_id和ques_type(1,2)取选择题错题数目
    
    Integer sumPanDuanTiScore(Integer paperResultId);	//根据paper_result_id和ques_type(4)取判断题实际得分
    Integer countPanDuanTiNum(Integer paperResultId);	//根据paper_result_id和ques_type(4)取判断题数目
    Integer countPanDuanTiWrongNum(Integer paperResultId);	//根据paper_result_id和ques_type(4)取选判断错题数目
    
    Integer sumTianKongTiScore(Integer paperResultId);	//根据paper_result_id和ques_type(5)取填空题实际得分
    Integer countTianKongTiNum(Integer paperResultId);	//根据paper_result_id和ques_type(5)取填空题数目
    Integer countTianKongTiWrongNum(Integer paperResultId);	//根据paper_result_id和ques_type(5)取填空题错题数目
    
    Integer sumWenDaTiScore(Integer paperResultId);	//根据paper_result_id和ques_type(3)取问答题实际得分
    Integer countWenDaTiNum(Integer paperResultId);	//根据paper_result_id和ques_type(3取问答题数目
    Integer countWenDaTiWrongNum(Integer paperResultId);	//根据paper_result_id和ques_type(3)取问答题错题数目
    
    List<AnsweredQuestion> getAnsweredQuestionsByPaperResultId(Integer paperresultid);
    
    List<AnsweredQuestion> getJudgeQuestionsByPaperResultId(Integer paperresultid);
    
    List<AnsweredQuestion> getTianKongQuestionsByPaperResultId(Integer paperresultid);
    
    List<AnsweredQuestion> getWenDaQuestionsByPaperResultId(Integer paperresultid);

	int updateAndInsert(AnsweredQuestion aq);

	int selectPrimeKey(Integer paperResultId, Integer quesType, Integer quesId);
	
	int selectAcquiredScore(Integer paperResultId);
	
	Integer getTotalRightQues(Integer stu_id,Integer ques_type);
	
	Integer getTotalQues(Integer stu_id,Integer ques_type);
	
}