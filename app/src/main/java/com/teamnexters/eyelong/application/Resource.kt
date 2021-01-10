package com.teamnexters.eyelong.application

enum class ImageResource(
    val id: Int,
    val iconImagePath: String?,
    val lottieImagePath: String?,
    val tipImagePath: String?,
    val guideImagePath: String?
) {
    EIGHT(
        id = 1,
        iconImagePath = "img_exercise_eight",
        lottieImagePath = null,
        tipImagePath = "img_exercise_tip_eight",
        guideImagePath = "img_exercise_guide_eight"
    ),

    BLINK(
        id = 2,
        iconImagePath = "img_exercise_blink",
        lottieImagePath = null,
        tipImagePath = null,
        guideImagePath = "img_exercise_guide_blink"
    ),

    STRETCHING(
        id = 3,
        iconImagePath = "img_exercise_stretching",
        lottieImagePath = null,
        tipImagePath = "img_exercise_tip_stretching_2_1" +
                ",img_exercise_tip_stretching_3_1" +
                ",img_exercise_tip_stretching_4_1" +
                ",img_exercise_tip_stretching_5_1" +
                ",img_exercise_tip_stretching_6_1" +
                ",img_exercise_tip_stretching_7_1",
        guideImagePath = "img_exercise_guide_stretching"
    ),

    NOSE(
        id = 4,
        iconImagePath = "img_exercise_nose",
        lottieImagePath = null,
        tipImagePath = null,
        guideImagePath = "img_exercise_guide_nose"
    ),

    X(
        id = 5,
        iconImagePath = "img_exercise_x",
        lottieImagePath = null,
        tipImagePath = null,
        guideImagePath = "img_exercise_guide_x"
    )
}

fun getImageResource(id: Int) = enumValues<ImageResource>().find { it.id == id }
fun getIconImagePath(id: Int) = getImageResource(id)?.iconImagePath
fun getLottieImagePath(id: Int) = getImageResource(id)?.lottieImagePath
fun getTipImagePath(id: Int) = getImageResource(id)?.tipImagePath
fun getGuideImagePath(id: Int) = getImageResource(id)?.guideImagePath