import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1139TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1139TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="native">
                    <n:h5>Testing step:</n:h5>
                    <n:ol>
                      <n:li> make the checkbox in caption become unchecked </n:li>
                      <n:li> change the value of "name" textbox</n:li>
                      <n:li> click "change name" button</n:li>
                      <n:li> the value of name should not changed</n:li>
                    </n:ol>
                    <window id="myWin" title="binder loadComponent loadinit false" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id(\'vm\') @init(\'org.zkoss.zktest.bind.basic.CompositeVM\')">
                      <caption>
                        <checkbox id="liChk" label="load Init" checked="true"/>
                      </caption>
                      <grid>
                        <rows>
                          <row>
                            <textbox id="nameTexb" value="@load(vm.name)"></textbox>
                            <button id="changeNameBtn" label="change name">
                              <attribute name="onClick"><![CDATA[
						myWin$composer.getViewModel().setName(nameTexb.getValue());
						myWin$composer.getBinder().loadComponent(myWin, liChk.isChecked());
					]]></attribute>
                            </button>
                          </row>
                          <row>name (init binding): <label id="nameLbl" value="@init(vm.name)"/></row>
                          <row>title: <label value="@bind(vm.title)"/> </row>
                          <row>value: <label value="@bind(vm.value)"/> </row>
                        </rows>
                      </grid>
                    </window>
                  </zk>`,
	);
	await t.click(Selector(() => jq("input[type*=checkbox]")[0]));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-textbox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-textbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("a a a a a");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(change name)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Dennis"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:eq(1) .z-label:eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"should not changed",
		);
});
