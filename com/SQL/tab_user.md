<table algin = "left">
    <tr algin = "left">用户表（tab_user） </tr>					
    <tr>
          <td>字段名</td><td>字段类型</td><td>是否可为空</td><td>默认值</td><td>字段含义</td><td>注释</td>
    </tr>
    <tr>
          <td>id</td><td>number(4)</td><td>N</td><td></td><td>ID</td><td>主键</td>
    </tr>
    <tr>
          <td>username</td><td>VARCHAR2(30)</td><td>N</td><td></td><td>用户名</td><td>唯一</td>
    </tr>
    <tr>
          <td>password</td><td>VARCHAR2(50)</td><td>N</td><td></td><td>密码</td><td></td>	
    </tr>
    <tr>
          <td>rule</td><td>VARCHAR2(2)</td><td>N</td><td>2</td><td>权限(1、管理员 2、普通用户)</td><td></td>	
    </tr>
    <tr>
          <td>realname</td><td>VARCHAR2(50)</td><td>N</td><td></td><td>真实姓名</td><td></td>	
    </tr>
    <tr>
          <td>sex</td><td>VARCHAR2(10)</td><td>N</td><td>1</td><td>性别(1、男 2、女)</td><td></td>	
    </tr>
    <tr>
         <td>city</td><td>VARCHAR2(6)</td><td>N</td><td></td><td>市信息ID值</td><td>关联tab_city表cityID字段</td>
    </tr>
    <tr>
         <td>cert_type</td><td>number(4)</td><td>N</td><td></td><td>证件类型字典ID值</td><td>关联tab_certtype表id字段</td>
    </tr>
    <tr>
         <td>cert</td><td>VARCHAR2(50)</td><td>N</td><td></td><td>证件号码</td><td></td>	
    </tr>
    <tr>
        <td>birthday</td><td>DATE</td><td>N</td><td></td><td>生日</td><td></td>	
    </tr>
    <tr>
        <td>user_type</td><td>number(4)</td><td>Y</td><td></td><td>旅客类型字典ID值</td><td>关联tab_usertype表id字段</td>
    </tr>
    <tr>
        <td>content</td><td>varchar2(3000)</td><td>Y</td><td></td><td>备注信息</td><td></td>
    </tr>
    <tr>
        <td>status</td><td>VARCHAR2(2)</td><td>N</td><td>1</td><td>用户状态（0、无效  1、有效 ）</td><td></td>	
    </tr>
    <tr>
        <td>login_ip</td><td>VARCHAR2(50)</td><td>Y</td><td></td><td>登录IP</td><td></td>	
    </tr>
    <tr>
        <td>image_path</td><td>VARCHAR2(200)</td><td>Y</td><td></td><td>用户头像路径</td><td></td>	
    </tr>
    <tr>
</table>
