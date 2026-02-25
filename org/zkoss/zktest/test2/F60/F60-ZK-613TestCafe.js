import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F60-ZK-613TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-613TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
				Clicks the following buttons one-by-one. They shall all generate "OK" at
				the end.
				]]></html>
				<separator bar="true"/>
			
				<button id="btnOne" label="test 1">
					<attribute name="onClick"><![CDATA[{
				Div d = new Div();
				Label l = new Label("test");
				l.setId("t1");
				d.appendChild(l);
				if (d.getFellowIfAny("t1") == null)
					alert("t1 not found");
				else if (l.getSpaceOwner() == null || d.getSpaceOwner() == null)
					alert("space owner is wrong: "+l.getSpaceOwner()+":"+d.getSpaceOwner());
				else if (self.getFellowIfAny("t1") != null)
					alert("t1 shall not in page");
				else
					inf.appendChild(new Label("OK"));
					}]]></attribute>
				</button>
			
				<button id="btnTwo" label="test 2">
					<attribute name="onClick"><![CDATA[{
				Div d = new Div();
				inf.appendChild(d);
				Label l = new Label("test");
				l.setId("t2");
				d.appendChild(l);
			
				if (d.getFellowIfAny("t2") == null)
					alert("t2 not found");
				else if (self.getFellowIfAny("t2") == null)
					alert("t2 not found");
				else {
					d.detach();
			
					if (d.getFellowIfAny("t2") == null)
						alert("t2 not found");
					else if (self.getFellowIfAny("t2") != null)
						alert("t2 shall not in page");
					else
						inf.appendChild(new Label("OK"));
				}
					}]]></attribute>
				</button>
			
				<vlayout id="inf"/>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-label:contains(OK)").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 1).ok("Should generate an OK");
	await t.click(Selector(() => zk.Desktop._dt.$f("btnTwo", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-label:contains(OK)").length,
	)();
	await t
		.expect(verifyVariable_cafe_1_1 == 2)
		.ok("Should generate another OK");
});
