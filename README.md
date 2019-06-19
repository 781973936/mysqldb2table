# mysqldb2table
## 项目结构
> com.lanshan.mysqldb2table 
>
> > App.java // 启动类
> 
> com.lanshan.mysqldb2table.db // 数据库操作包
>
> > Database.java // 连接数据库，获取数据库信息
>
> > Table.java // 表结构
>
> > Field.java // 字段结构
>
> com.lanshan.mysqldb2table.excel // excel操作
>
> > ExcelStand.java // excel操作接口
>
> > TotalTable.java // 具体实现，获取表概况
>
> > TotalTableInfo.java // 具体实现，获取表详细信息
>
> com.lanshan.mysqldb2table.poi // poi操作
>
> > PoiGroup.java // poi操作接口
>
> > PoiOperation.java // poi操作具体实现
## 具体使用
### 获取表概况
    public class App 
    {
      public static void main(String[] args) {
        ExcelStand excel = new TotalTable();
        excel.createFile();
        System.out.println("生成完毕！");
      }
    }
