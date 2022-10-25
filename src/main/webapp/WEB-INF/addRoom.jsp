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
    <h1 class="text-4xl font-medium">Add Room</h1>

    <form action="" class="my-10" method="post">
        <div class="flex flex-col space-y-5">
            <label>
                <p class="font-medium text-slate-700 pb-2">Type</p>
                <select name="type" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow">
                    <option value="0">Single</option>
                    <option value="1">Double</option>
                    <option value="2">Triple</option>
                    <option value="3">Suite</option>
                </select>
            </label>
            <label for="number">
                <p class="font-medium text-slate-700 pb-2">Number</p>
                <input id="number" name="number" type="text" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow" placeholder="Enter the room's number">
            </label>
            <label for="floor">
                <p class="font-medium text-slate-700 pb-2">Floor</p>
                <input id="floor" name="floor" type="text" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow" placeholder="Enter the floor's number">
            </label>
            <label for="description">
                <p class="font-medium text-slate-700 pb-2">Description</p>
                <input id="description" name="description" type="text" class="w-full py-3 border border-slate-200 rounded-lg px-3 focus:outline-none focus:border-slate-500 hover:shadow" placeholder="Enter the description of the room">
            </label>


            <div class="mb-6 pt-4">
                <label class="mb-5 block text-xl font-semibold text-[#07074D]">
                    Upload Image
                </label>

                <div class="mb-8">
                    <input type="file" name="file" id="file" class="sr-only" />
                    <label for="file" class="relative flex min-h-[200px] items-center justify-center rounded-md border border-dashed border-[#e0e0e0] p-12 text-center">
                        <div>
                            <span class="mb-2 block text-xl font-semibold text-[#07074D]">Drop images here</span>
                            <span class="mb-2 block text-base font-medium text-[#6B7280]">Or</span>
                            <span class="inline-flex rounded border border-[#e0e0e0] py-2 px-7 text-base font-medium text-[#07074D]">Browse</span>
                        </div>
                    </label>
                </div>

                <div class="mb-5 rounded-md bg-[#F5F7FB] py-4 px-8">
                    <div class="flex items-center justify-between">
                        <span class="truncate pr-3 text-base font-medium text-[#07074D]">banner-design.png</span>
                        <button class="text-[#07074D]">
                            <svg width="10" height="10" viewBox="0 0 10 10" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" clip-rule="evenodd" d="M0.279337 0.279338C0.651787 -0.0931121 1.25565 -0.0931121 1.6281 0.279338L9.72066 8.3719C10.0931 8.74435 10.0931 9.34821 9.72066 9.72066C9.34821 10.0931 8.74435 10.0931 8.3719 9.72066L0.279337 1.6281C-0.0931125 1.25565 -0.0931125 0.651788 0.279337 0.279338Z" fill="currentColor"/>
                                <path fill-rule="evenodd" clip-rule="evenodd" d="M0.279337 9.72066C-0.0931125 9.34821 -0.0931125 8.74435 0.279337 8.3719L8.3719 0.279338C8.74435 -0.0931127 9.34821 -0.0931123 9.72066 0.279338C10.0931 0.651787 10.0931 1.25565 9.72066 1.6281L1.6281 9.72066C1.25565 10.0931 0.651787 10.0931 0.279337 9.72066Z" fill="currentColor"/>
                            </svg>
                        </button>
                    </div>
                </div>

                <div class="rounded-md bg-[#F5F7FB] py-4 px-8">
                    <div class="flex items-center justify-between">
            <span class="truncate pr-3 text-base font-medium text-[#07074D]">
              banner-design.png
            </span>
                        <button class="text-[#07074D]">
                            <svg width="10" height="10" viewBox="0 0 10 10" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" clip-rule="evenodd" d="M0.279337 0.279338C0.651787 -0.0931121 1.25565 -0.0931121 1.6281 0.279338L9.72066 8.3719C10.0931 8.74435 10.0931 9.34821 9.72066 9.72066C9.34821 10.0931 8.74435 10.0931 8.3719 9.72066L0.279337 1.6281C-0.0931125 1.25565 -0.0931125 0.651788 0.279337 0.279338Z" fill="currentColor"/>
                                <path fill-rule="evenodd" clip-rule="evenodd" d="M0.279337 9.72066C-0.0931125 9.34821 -0.0931125 8.74435 0.279337 8.3719L8.3719 0.279338C8.74435 -0.0931127 9.34821 -0.0931123 9.72066 0.279338C10.0931 0.651787 10.0931 1.25565 9.72066 1.6281L1.6281 9.72066C1.25565 10.0931 0.651787 10.0931 0.279337 9.72066Z" fill="currentColor"/>
                            </svg>
                        </button>
                    </div>
                    <div class="relative mt-5 h-[6px] w-full rounded-lg bg-[#E2E5EF]">
                        <div class="absolute left-0 right-0 h-full w-[75%] rounded-lg bg-[#6A64F1]"></div>
                    </div>
                </div>
            </div>

            <button type="submit" class="w-full py-3 font-medium text-white bg-blue-500 hover:bg-blue-400 rounded-lg border-blue-500 hover:shadow inline-flex space-x-2 items-center justify-center">
                <span>Submit</span>
            </button>

        </div>
    </form>
</div>

</body>
</html>
