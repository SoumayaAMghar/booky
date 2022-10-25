<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 21/10/2022
  Time: 16:37
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
        <a href="index.jsp" class="bg-blue-500 text-gray-200  p-2 rounded  hover:bg-blue-500 hover:text-gray-100">Sign out</a>
      </div>
    </div>
  </div>
</nav>




</body>
</html>
