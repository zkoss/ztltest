import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1921891TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1921891TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
Click <button label="move" onClick="lb.insertBefore(li, li)"/>
and nothing shall happens (correct).
In 3.0.3 or earlier, ClassCastException is thrown - it is incorrect.
	<listbox id="lb" multiple="true" width="300px">
		<listhead>
		<listheader label="Country/Area"/>
		<listheader align="right" label="Visits"/>
		<listheader align="right" label="%"/>
		</listhead>
		<listitem id="li">
		<listcell label="United States"/>
		<listcell label="5,093"/>
		<listcell label="19.39%"/>
		</listitem>
		<listfoot>
		<listfooter label="Total 132"/>
		<listfooter label="26,267"/>
		<listfooter label="100.00%"/>
		</listfoot>
	</listbox>
</window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => !!jq('@window[title="ZK Test"]')[0])(),
		)
		.notOk();
});
