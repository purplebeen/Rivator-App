package com.rinc.bong.rivatorproject.retrofitBean;

import com.google.gson.annotations.SerializedName;
import com.rinc.bong.rivatorproject.beans.CourseReview;
import com.rinc.bong.rivatorproject.beans.Result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by baehyeonbin on 2017. 9. 27..
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseReviewGet {
    @SerializedName("status")
    private Result result;
    @SerializedName("courseReview")
    private CourseReview courseReview;
}
