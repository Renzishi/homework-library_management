# 图书管理系统数据库连接与操作部分
#### JAVA MySQL

### 数据库信息配置于config文件中

## 新增/插入 (controller package)

> ### Insert 类
> `public int insert()` 
>- 新增/插入数据，如果数据存在则增加其库存（可批量操作）

## 删除 (controller package)

> ### Delete 类 
> `public void deleteMsg()`
>- 删除已存在的数据（可批量操作）

## 查询 (controller package)

> ### Get 类 
> `public Vector<Message> getMsg()`
>- 查询并返回所有数据（可批量操作）

## 修改/更新 (controller package)

> ### Update 类 
> `public void update()`
>- 修改/更新数据（可批量操作）

## 登录 (login package)

> ### Login 类 
> `public boolean login()`
>- 判断登录是否成功

## 注册 (login package)

> ### Register 类
> `public boolean reg()`
>- 判断用户是否存在并完成注册

## 消息体 (model package)

> ### Message 类
> `public Message()`
>-  含有一个消息的所有数据
>-  name, number, borrowed, remain
