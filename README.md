# 安卓架构


#### 常用界面

![](picture/activity/1.png) ![](picture/activity/2.png) ![](picture/activity/3.png)

![](picture/activity/4.png) ![](picture/activity/5.png) ![](picture/activity/6.png)

![](picture/activity/7.png) ![](picture/activity/8.png) ![](picture/activity/9.png)

![](picture/activity/11.png) ![](picture/activity/12.png) ![](picture/activity/13.png)

![](picture/activity/14.png) ![](picture/activity/15.png) ![](picture/activity/16.png)

![](picture/activity/17.png) ![](picture/activity/18.png) ![](picture/activity/19.png)

![](picture/activity/20.png) ![](picture/activity/21.png) ![](picture/activity/22.png)

#### 常用对话框

![](picture/dialog/1.png) ![](picture/dialog/2.png) ![](picture/dialog/3.png)

![](picture/dialog/4.png) ![](picture/dialog/5.png) ![](picture/dialog/6.png)

![](picture/dialog/7.png) ![](picture/dialog/8.png) ![](picture/dialog/9.png)

![](picture/dialog/10.png) ![](picture/dialog/11.png) ![](picture/dialog/12.png)

![](picture/dialog/13.png) ![](picture/dialog/14.png) ![](picture/dialog/15.png)

#### 动图欣赏

![](picture/gif/1.gif) ![](picture/gif/2.gif) ![](picture/gif/3.gif)

![](picture/gif/4.gif) ![](picture/gif/5.gif) ![](picture/gif/6.gif)

#### 集成框架

* 权限请求框架：[https://github.com/getActivity/XXPermissions](https://github.com/getActivity/XXPermissions)

* 标题栏：[https://github.com/getActivity/TitleBar](https://github.com/getActivity/TitleBar)

* 吐司工具类：[https://github.com/getActivity/ToastUtils](https://github.com/getActivity/ToastUtils)

* 状态栏沉浸：[https://github.com/gyf-dev/ImmersionBar](https://github.com/gyf-dev/ImmersionBar)

* 缩放 ImageView：[https://github.com/chrisbanes/PhotoView](https://github.com/chrisbanes/PhotoView)

* ViewPager 指示器：[https://github.com/romandanylyk/PageIndicatorView](https://github.com/romandanylyk/PageIndicatorView)

* ButterKnife 注解：[https://github.com/JakeWharton/butterknife](https://github.com/JakeWharton/butterknife)

* EventBus 事件：[https://github.com/greenrobot/EventBus](https://github.com/greenrobot/EventBus)

* 内存泄漏捕捉：[https://github.com/square/leakcanary](https://github.com/square/leakcanary)

* 本地异常捕捉：[https://github.com/Ereza/CustomActivityOnCrash](https://github.com/Ereza/CustomActivityOnCrash)

#### 模板项目亮点，[查看详细](ProjectDetails.md)

* 必备优秀框架：危险权限处理，标题栏控件，吐司工具类，圆形ImageView

* 常用页面模板：启动界面，主页界面，登录界面，注册界面，关于界面，浏览器界面

* 集成友盟统计：集成友盟统计，并且加入了友盟多渠道打包，在发布release包时可选择渠道包

* 界面样式规范：项目的严格按照 Material Design 设计进行配色，统一和规范Button和EditText控件样式

* 常用自定义View：圆形ImageView，验证码点击倒计时View，带清除按钮的EditText，正方形的FrameLayout、LinearLayout、RelativeLayout、ImageView

* 代码注释规范：代码严格按照谷歌级规范来做，如需寻找友盟相关的代码，全局搜索 "友盟" 即可，任何一处不关于原生的 API 都有非常完善的注释

#### 修复Android普遍存在的问题，[查看详细](AndroidBug.md)

* 修复 Button 在Android 5.1 之后英文字符串自动大写的问题

* 修复 Button 在设置状态选择器后仍然残留按压阴影的问题

* 修复某些低配置机型启动页停留在白屏的时间比较长的问题

* 修复某些机型在 WebView 长按时布局被顶下来的问题

* 修复 任务栈中 首页Activity 被重复启动的问题

* 修正 Android 9.0 限制 Http 明文请求的问题

