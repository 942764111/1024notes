## 文件下载

### Excel下载

1. 网页 添加下载链接

		<a href="download.do">下载Excel</a>

2. 导入Apache POI 包

		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>3.12</version>
		</dependency>

3. 创建控制器
	- 修改Http协议头
	- POI api  生成Excel文件流（byte[]）

			@RequestMapping(value="/download.do",
					produces="application/vnd.ms-excel")
			@ResponseBody
			public byte[] download(HttpServletResponse res)
				throws IOException{
				
				res.addHeader("Content-Disposition",
						"attachment; filename=\"hello.xls\"");
				//res.setContentType("application/vnd.ms-excel");
				//创建Excel工作薄对象
				HSSFWorkbook workbook=new HSSFWorkbook();
				//在工作簿中创建工作表
				HSSFSheet sheet=workbook.createSheet();
				//创建一行
				HSSFRow row=sheet.createRow(0);//行号
				//创建一个格子
				HSSFCell cell=row.createCell(0);//列号
				//向格子填充数据
				cell.setCellValue("Hello World!");
				
				//将Excel对象序列化为 byte[]数据
				ByteArrayOutputStream out=
					new ByteArrayOutputStream();
				workbook.write(out); 
				workbook.close();
				
				byte[] buf=out.toByteArray();
				return buf;
			}