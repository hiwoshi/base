1.项目简介<br/>
    项目设计是为了让人可以轻松搭建一个简单的springboot项目，开发者可以在此项目的基础上，进行自己的业务开发。<br/>
    
2.模块介绍<br/>
    autocode： 自动编码模块，开发环境使用此jar包，生产环境可以去除此jar。用户可以访问    ip:port/***.html，按流程自动
        生成相应的代码。<br/>
    common： 基础业务模块，包含基础的CRUD方法。<br>
    demo：   开发模块，生成的代码都在此模块下，项目也是在此模块下进行启动。<br>
    
3.运行项目<br/>
    本地运行： 运行demo下的com.demo.Start.Main方法。<br/>
    打包： 将demo模块打成所需的包，进行部署运行。<br/>
    
4.额外声明<br/>
    本项目仅是为项目开发提供一些便捷的方式，不用作任何商业用途。如果在使用过程中，发现任何问题，或者不便。欢迎提issues
    至此项目。
