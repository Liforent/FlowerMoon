package com.zss.liforent.flowermoon.module.home.data

/**
 *
 *@Author:  Liforent
 *@CreateTime: 2021/04/23 9:40
 *@Descriptions:
 */
data class ArticalListResponse(
        var apkLink: String,
        var audit: Int,
        var author: String,
        var canEdit: Boolean,
        var chapterId: Int,
        var chapterName: String,
        var collect: Boolean,
        var courseId: Int,
        var desc: String,
        var descMd: String,
        var id: Int,
        var link: String,
        var niceData: String,
        var niceShareData: String,
        var publishTime: Long,
        var realSuperChapterId: Int,
        var selfVisible: Boolean,
        var shareDate: Long,
        var shareUser: String,
        var superChapterId: Int,
        var superChapterName: String,
        var tags: List<Tag>,
        var title: String,
        var type: Int,
        var userId: Int,
        var visible: Int,
        var zan: Int

) {
    data class Tag(
            var name: String,
            var url: String
    )
}
