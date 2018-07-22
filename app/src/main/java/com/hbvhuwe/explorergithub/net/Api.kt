package com.hbvhuwe.explorergithub.net

import com.hbvhuwe.explorergithub.models.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface Api {
    @GET("/users/{user}/repos")
    fun getReposForUser(@Path("user") user: String): Call<List<Repo>>

    @GET("/user/repos")
    fun getReposForUser(): Call<List<Repo>>

    @GET("/user/starred")
    fun getStarredRepos(): Call<List<Repo>>

    @GET("/users/{user}/starred")
    fun getStarredRepos(@Path("user") user: String): Call<List<Repo>>

    @GET("/users/{user}")
    fun getUserInfo(@Path("user") user: String): Call<User>

    @GET("/user")
    fun getUserInfo(): Call<User>

    @GET("/repos/{user}/{repo}/branches")
    fun getBranchesForRepo(
            @Path("user") user: String,
            @Path("repo") repo: String
    ): Call<List<GitHubBranch>>

    @GET("/repos/{user}/{repo}/commits")
    fun getCommitsOfRepo(
            @Path("user") user: String,
            @Path("repo") repo: String
    ): Call<List<GitHubCommit>>

    @GET("/repos/{user}/{repo}/contents/{path}")
    fun getContentOfPath(
            @Path("user") user: String,
            @Path("repo") repo: String,
            @Path("path") path: String,
            @Query("ref") branch: String = "master"
    ): Call<List<GitHubFile>>

    @GET
    fun getFile(@Url url: String): Call<ResponseBody>
}