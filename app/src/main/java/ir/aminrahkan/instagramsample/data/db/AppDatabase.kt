package ir.aminrahkan.instagramsample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.aminrahkan.instagramsample.data.db.dao.CommentDao
import ir.aminrahkan.instagramsample.data.db.dao.PostDao
import ir.aminrahkan.instagramsample.data.db.entities.Comment
import ir.aminrahkan.instagramsample.data.db.entities.Post


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/13/22 - 2022
// Project name : Instagram Sample

@Database(entities = [Post::class, Comment::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao

}