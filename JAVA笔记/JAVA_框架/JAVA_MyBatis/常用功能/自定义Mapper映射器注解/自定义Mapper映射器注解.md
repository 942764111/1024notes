#自定义映射器注解
##一、定义映射器接口

	public @interface MyBatisRepository {
	
	}


	
##二、使用映射器

	/**
	 * Mapper映射器
	 *
	 */
	@Repository("eDAO")
	@MyBatisRepository
	public interface EmpDAO {
		public void save(Employee e);
		public List<Employee> findAll();
		public Employee findById(int id);
		public void modify(Employee e);
		public void delete(int id);
		public Map findById2(int id);
		public Employee2 findById3(int id);
	}
##三、只扫描带有特定注解的接口

	<!-- 配置MapperScannerConfigurer -->
	<!-- 
	注:该Bean会扫描指定包及其子包下面所有的映射器
	（接口）,	然后调用SqlSession的getMapper方法，
	并且将该方法的返回值（就是实现了映射器接口的对象）放到Spring容器里面（默认的
	id是首字母小写之后的接口名）
	 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" 
		value="dao"/>
		<!-- 只扫描带有特定注解的接口 -->
		<property name="annotationClass"
		value="annotations.MyBatisRepository"/>
	</bean>