<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 20/10/2022
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<!-- component -->
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
    <h1 class="text-4xl font-medium">Add Extra</h1>

    <form action="" class="my-10" method="post">
        <div class="flex flex-col space-y-5">
            <label>
                <p class="font-medium text-slate-700 pb-2">Type</p>
                <select name="type" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow">
                    <option value="0">Breakfast</option>
                    <option value="1">Lunch</option>
                    <option value="2">Dinner</option>
                    <option value="3">Fruits</option>
                    <option value="4">Music</option>
                    <option value="5">Spa</option>
                    <option value="6">Massage</option>
                    <option value="7">Care</option>
                </select>
            </label>
            <label for="price">
                <p class="font-medium text-slate-700 pb-2">Price</p>
                <input id="price" name="price" type="text" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow" placeholder="Enter the price">
            </label>

            <button type="submit" class="w-full py-3 font-medium text-white bg-blue-500 hover:bg-blue-400 rounded-lg border-blue-500 hover:shadow inline-flex space-x-2 items-center justify-center">
                <span>Submit</span>
            </button>

        </div>
    </form>
</div>

</body>
</html>
