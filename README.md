---

---

# 科研人员管理系统

## 需求分析

因为学校里的老师对于给自己的学生安排的各类任务，以及学生平时的学习任务没有一个数据库去记录下来，以便以后查看，这个系统可以帮助老师监督学生的学习情况，以及了解学生的成果。

## 实现的功能

基于需求我们需要实现以下功能：

1. 基本的学生与教师信息管理；
2. 学生与老师的成果管理；
3. 学生的计划管理；
4. 老师对于学生计划的建议（做了已读功能）；
5. 课题小组管理（完成一个大任务的小组，包括老师和学生）；
6. 针对课题小组做了小组的成果管理；

## 做了三个管理段

### 管理员端

能够对学生基本信息、教师基本信息等相关数据录入、修改等操作。

### 老师端

1)能够根据自己的工号和密码查询个人信息。

2)管理自己的学生（增删改查）。

3)查看每位学生的个人计划、进度和完成情况（是否已读、留下建议）。

4)修改，提交个人成果表内容。

5)若为该教师为项目负责人，则可查看所关联小组的计划，进度，和完成情况（是否已读，留下建议）。

### 学生端

1)能够根据自己的学号和密码查询个人信息。

2)编辑自己的计划（增改查）。

3)修改，提交个人计划内容，任务进度，任务状态。

4)修改，提交所属小组计划内容，任务进度，任务状态。

5)修改，提交个人成果表内容。

