import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3309122TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3309122TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			If you can see 10 and Western in the content, the bug has been fixed.
			<zscript><![CDATA[
			public class Employee {
			protected int id;
			protected String lastName;
			
			public Employee(int id, String lastName) {
			this.id = id;
			this.lastName = lastName;
			}
			public int getId() {
			return id;
			}
			public void setId(int id) {
			this.id = id;
			}
			public String getLastName() {
			return lastName;
			}
			
			public void setLastName(String lastName) {
			this.lastName = lastName;
			}
			
			}
			public class EmployeeService2 {
			public ArrayList getEmployees() {
			return EMPLOYEE_POOL;
			}
			
			protected static ArrayList EMPLOYEE_POOL = new ArrayList(3000);
			public EmployeeService2(){
			for(int i=0;i!=500;i++){
			EMPLOYEE_POOL.add(new Employee(10, "Western"));
			}
			}
			}
			
			public class MyRowRenderer implements RowRenderer{
			public void render(Row row, java.lang.Object data, int index) {
			Employee emp = (Employee)data;
			new Label(Integer.toString(emp.getId())).setParent(row);
			new Label(emp.getLastName()).setParent(row);
			}
			}
			
			public class MyGrid2 extends Grid{
			protected static EmployeeService2 provider;
			public ArrayList getEmployees(){
			return provider.getEmployees();
			}
			public SimpleListModel getMyModel(){
			return new SimpleListModel(getEmployees());
			}
			public MyRowRenderer getMyRenderer(){
			return new MyRowRenderer();
			}
			public void onCreate(){
			setModel(getMyModel());
			setRowRenderer(getMyRenderer());
			}
			public MyGrid2() {
			provider = new EmployeeService2();
			}
			}
			]]></zscript>
			
			<grid id="grid" use="MyGrid2" height="300px">
			<columns>
			<column label="Author"/>
			<column label="Title"/>
			</columns>
			</grid>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[0],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[0],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[1],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[1],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[2],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[2],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[3],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[3],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[4],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[4],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[5],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[5],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[6],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[6],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[7],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[7],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[8],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[8],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[9],
						).find(".z-label")[0].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("10"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(zk.Desktop._dt.$f("grid", true).$n("body"))
								.find(".z-rows")
								.find(".z-row")[9],
						).find(".z-label")[1].innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("Western"), "");
});
