package com.example.ecommerce_app.Api

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

 interface Calls {
    //pducts
    //get all products
    @GET("/products")

    //get single product
    @GET("/products/1")

    //sort products
    @GET("/products?sort=desc")

    @GET("/products/categories")

    //add new priduct
    @POST("/products")

    //update produt
    @PUT("/products/7")

    //delete proudt
    @DELETE("/products/6")

    //cart

    //get all carts
    @GET("/carts/startdate=2019-12-10&enddate=2020-10-10")

    //get single cart
    @GET("/carts/user/2")

    //limit carts
    @GET("/carts?limit=5")

    //sort results
    @GET("/carts?sort=desc")

    //add cart
    @POST("/carts")

    //update cart
   @PUT("/carts/7")

    //delete cart
    @DELETE("/carts/6")

    //user
    //get all users
    @GET("/users")

    //get single user
    @GET("com/users/1")

    //limit result
    @GET("/users?limit=5")

    //sort user
    @GET("/users?sort=desc")

    //add user
    @POST("/users")

    //update user
    @PUT("/users/7")

    //delete user
    @DELETE("/users/6")

    //login user
    @POST("/auth/login")





}