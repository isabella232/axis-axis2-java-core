<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
 /*
* Copyright 2004,2005 The Apache Software Foundation.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
*
*/

/**
* Author : Deepal Jayasinghe
* Date: May 26, 2005
* Time: 7:14:26 PM
*/
--%>
<html>
  <head>
    <jsp:include page="include/httpbase.jsp"/>
    <title>Login to Axis2:: Administration page</title>
    <link href="axis2-web/css/axis-style.css" rel="stylesheet" type="text/css">
  </head>

  <body onload="javascript:document.LoginForm.userName.focus();">
    <jsp:include page="include/header.inc"/>
    <jsp:include page="include/link-footer.jsp"/>
    <table class="FULL_BLANK">
      <tr>
        <td valign="top"></td>
        <td valign="middle" align="left">
          <form method="post" name="LoginForm" action="axis2-admin/login">
            <table class="LOG_IN_FORM">
              <tr>
                <td align="center" colspan="2" bgcolor="#b0b0b0" color="#FFFFFF"><font color="#FFFFFF">Login</font></td>
              </tr>
              <tr>
                 <td align="center" colspan="2">&nbsp;</td>
               </tr>
              <tr>
                <td align="right">User :</td>
                <td><input align="left" type="text" name="userName" tabindex="1">
                </td>
              </tr>
              <tr>
                <td align="right">Password : </td>
                <td><input align="left" type="password" name="password" tabindex="2">
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  <br>
                </td>
              </tr>
              <tr>
                <td align="center" colspan="2">
                  <input name="cancel" type="reset" value=" Clear "> &nbsp; &nbsp;
                  <input name="submit" type="submit" value=" Login ">
                </td>
              </tr>
              <tr>
                <td align="center" colspan="2">
                  <font color="red">&nbsp;<% if (request.getAttribute("errorMessage") != null) {%><%= request.getAttribute("errorMessage")%><% } %>&nbsp;</font>
                </td>
              </tr>
            </table>
          </form>
          <br/><br/><br/><br/><br/><br/>
        </td>
      </tr>
    </table>
    <jsp:include page="include/footer.inc"/>
  </body>
</html>

