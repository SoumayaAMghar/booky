<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 19/10/2022
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<!-- component -->
<body class="antialiased bg-slate-200">
<nav id="header" class="w-full z-30 top-10 py-1 bg-blue-100/90  shadow-lg border-b border-blue-400 ">
    <div class="w-full flex items-center justify-between mt-0 px-6 py-2">
        <label for="menu-toggle" class="cursor-pointer md:hidden block">
            <svg class="fill-current text-blue-600" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 20 20">
                <title>menu</title>
                <path d="M0 3h20v2H0V3zm0 6h20v2H0V9zm0 6h20v2H0v-2z"></path>
            </svg>
        </label>
        <input class="hidden" type="checkbox" id="menu-toggle">

        <div class="hidden md:flex md:items-center md:w-auto w-full order-3 md:order-1" id="menu">
            <nav>
                <a class="nav-brand mr-auto ml-0" href="index.jsp"><img class="ml-6 w-16 h-16" src="hotel.png"></a>
            </nav>
        </div>

        <div class="order-2 md:order-3 flex flex-wrap items-center justify-end mr-0 md:mr-4" id="nav-content">
            <div class="auth flex items-center w-full md:w-full">
                <a href="login.jsp" class="bg-transparent text-gray-800  p-2 rounded border border-gray-300 mr-4 hover:bg-gray-100 hover:text-gray-700">Sign in</a>
                <a href="register.jsp" class="bg-blue-500 text-gray-200  p-2 rounded  hover:bg-blue-500 hover:text-gray-100">Sign up</a>
            </div>
        </div>
    </div>
</nav>
<div class="max-w-lg mx-auto my-10 bg-white p-8 rounded-xl shadow shadow-slate-300">
    <h1 class="text-4xl font-medium">Login</h1>
    <p class="text-slate-500">Hi, Welcome back 👋</p>
    <form action="" class="my-10" method="post">
        <div class="flex flex-col space-y-5">
            <label for="username">
                <p class="font-medium text-slate-700 pb-2">Username</p>
                <input id="username" name="username" type="text" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow" placeholder="Enter your username">
            </label>
            <label for="password">
                <p class="font-medium text-slate-700 pb-2">Password</p>
                <input id="password" name="password" type="password" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow" placeholder="Enter your password">
            </label>
            <button class="w-full py-3 font-medium text-white bg-blue-500 hover:bg-blue-400 rounded-lg border-blue-500 hover:shadow inline-flex space-x-2 items-center justify-center">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1" />
                </svg>
                <span>Login</span>
            </button>
            <p class="text-center">Not registered yet? <a href="register.jsp" class="text-blue-500 font-medium inline-flex space-x-1 items-center"><span>Register now </span><span><svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M10 6H6a2 2 0 00-2 2v10a2 2 0 002 2h10a2 2 0 002-2v-4M14 4h6m0 0v6m0-6L10 14" />
                  </svg></span></a></p>
        </div>
    </form>
</div>
</body>
</html>
