package com.teamnexters.eyelong.application

enum class ImageResource(
    val id: Int,
    val iconImagePath: String?,
    val lottieImagePath: List<String>?,
    val tipImagePath: List<String>?,
    val guideImagePath: String?
) {
    EIGHT(
        id = 1,
        iconImagePath = "img_exercise_eight",
        lottieImagePath = listOf(
            "lottie_eye_eight_1.json",
            "lottie_eye_eight_2.json",
            "lottie_eye_eight_3.json",
            "lottie_eye_eight_4.json",
            "lottie_eye_eight_5.json",
            "lottie_eye_eight_6.json"
        ),
        tipImagePath = listOf("img_exercise_tip_eight"),
        guideImagePath = "img_exercise_guide_eight"
    ),

    BLINK(
        id = 2,
        iconImagePath = "img_exercise_blink",
        lottieImagePath = listOf(
            "lottie_eye_blink_1_1.json",
            "lottie_eye_blink_1_2.json",
            "lottie_eye_blink_1_3.json",
            "lottie_eye_blink_2_1.json",
            "lottie_eye_blink_2_2.json",
            "lottie_eye_blink_2_3.json",
            "lottie_eye_blink_3_1.json",
            "lottie_eye_blink_3_2.json",
            "lottie_eye_blink_3_3.json"
        ),
        tipImagePath = null,
        guideImagePath = "img_exercise_guide_blink"
    ),

    STRETCHING(
        id = 3,
        iconImagePath = "img_exercise_stretching",
        lottieImagePath = listOf(
            "lottie_eye_stretching_1_1.json",
            "lottie_eye_stretching_2_1.json",
            "lottie_eye_stretching_2_2.json",
            "lottie_eye_stretching_3_1.json",
            "lottie_eye_stretching_3_2.json",
            "lottie_eye_stretching_4_1.json",
            "lottie_eye_stretching_4_2.json",
            "lottie_eye_stretching_5_1.json",
            "lottie_eye_stretching_5_2.json",
            "lottie_eye_stretching_6_1.json",
            "lottie_eye_stretching_6_2.json",
            "lottie_eye_stretching_7_1.json",
            "lottie_eye_stretching_7_2.json"
        ),
        tipImagePath = listOf(
            "img_exercise_tip_stretching_1_1",
            "img_exercise_tip_stretching_2_1",
            "img_exercise_tip_stretching_3_1",
            "img_exercise_tip_stretching_4_1",
            "img_exercise_tip_stretching_5_1",
            "img_exercise_tip_stretching_6_1",
            "img_exercise_tip_stretching_7_1"
        ),
        guideImagePath = "img_exercise_guide_stretching"
    ),

    NOSE(
        id = 4,
        iconImagePath = "img_exercise_nose",
        lottieImagePath = listOf(
            "lottie_nose_massage_1.json",
            "lottie_nose_massage_2.json",
            "lottie_nose_massage_3.json"
        ),
        tipImagePath = null,
        guideImagePath = "img_exercise_guide_nose"
    ),

    X(
        id = 5,
        iconImagePath = "img_exercise_x",
        lottieImagePath = listOf(
            "lottie_eye_x_1.json",
            "lottie_eye_x_2.json",
            "lottie_eye_x_3.json",
            "lottie_eye_x_4.json"
        ),
        tipImagePath = null,
        guideImagePath = "img_exercise_guide_x"
    )
}

fun getImageResource(id: Int) = enumValues<ImageResource>().find { it.id == id }
fun getIconImagePath(id: Int) = getImageResource(id)?.iconImagePath
fun getLottieImagePath(id: Int) = getImageResource(id)?.lottieImagePath
fun getTipImagePath(id: Int) = getImageResource(id)?.tipImagePath
fun getGuideImagePath(id: Int) = getImageResource(id)?.guideImagePath