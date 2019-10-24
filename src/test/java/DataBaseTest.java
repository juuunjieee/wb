import com.ulwx.database.DataBase;
import com.ulwx.database.sql.SqlUtils;
import com.yscf.admin.utils.DataBaseFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DataBaseTest {

	public static void testDataBaseToJavaBean() {
		SqlUtils.exportTables("tt1", "common-base", "e:/okok3", "com.ulwxbase.domain.db", "utf-8", false);
	}

	public static void createTable() {
		String dropsql = "drop table AA";

	}

	public static void insert() throws Exception {
//		AA a = new AA();
//		DataBase db = DataBaseFactory.getDataBase();
//
//		db.excuteInsertClass(a);
//		db = DataBaseFactory.getDataBase();
//		String sql = "select * from AA";
//		System.out.println(com.ulwx.tool.ObjectUtils.toJsonString(db.doQueryClass(AA.class, sql, null)));
//		
		AA b = new AA();
		b.setId(24);;
		b.setA(null);
		b.setB(null);
		DataBase db = DataBaseFactory.getDataBase();
		db.excuteUpdateWholeClass(b, "id");

	}

	public static void main(String[] args) throws Exception {
		// testDataBaseToJavaBean();
		insert();
//		AA a = new AA();
//		PropertyUtil.setProperty(a, "a", 3333);
//		System.out.println(com.ulwx.tool.ObjectUtils.toJsonString2(a));
//		System.out.println(PropertyUtil.getPropertyType(a, "a"));// getProperty
//		System.out.println(PropertyUtil.getProperty(a, "a"));
//		System.out.println(PropertyUtil.describe(a));
	}





public static class AA extends BB {
		private Integer id;
		private Integer a = 123;
		private String b = "234";
		private Long c = 4567L;
		private Boolean d = true;
		private LocalDate e = LocalDate.now();
		private Double f = 566.7d;
		private Float g = 566.444f;
		private LocalDateTime h = LocalDateTime.now();

		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		private Date i = new Date();

		private boolean j = true;

		public boolean isJ() {
			return j;
		}

		public void setJ(boolean j) {
			this.j = j;
		}

		public Integer getA() {
			return a;
		}

		public void setA(Integer a) {
			this.a = a;
		}

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}

		public Long getC() {
			return c;
		}

		public void setC(Long c) {
			this.c = c;
		}

		public Boolean getD() {
			return d;
		}

		public void setD(Boolean d) {
			this.d = d;
		}

		public LocalDate getE() {
			return e;
		}

		public void setE(LocalDate e) {
			this.e = e;
		}

		public Double getF() {
			return f;
		}

		public void setF(Double f) {
			this.f = f;
		}

		public Float getG() {
			return g;
		}

		public void setG(Float g) {
			this.g = g;
		}

		public LocalDateTime getH() {
			return h;
		}

		public void setH(LocalDateTime h) {
			this.h = h;
		}

		public Date getI() {
			return i;
		}

		public void setI(Date i) {
			this.i = i;
		}

	}

}

class BB {
	private Integer AA = 555555;

//	private Integer a = 777777;
//
//	public Integer getA() {
//		return a;
//	}
//
//	public void setA(Integer a) {
//		this.a = a;
//	}

	public Integer getAA() {
		return AA;
	}

	public void setAA(Integer aA) {
		AA = aA;
	}
}
