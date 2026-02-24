import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1826101TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1826101TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<window>
				
				<n:ol>
				<n:li>Listbox with mold = paging:</n:li>
				<n:li>It should have scrollbar when columns do not fit in the container;</n:li>
				<n:li>It shouldn\'t allow to set the size of columns smaller than contents in IE6.0. </n:li>
				</n:ol>
				
				</window>
				<window title="listbox demo" border="normal" width="80px">
				
					<listbox width="95%" mold="paging">
						<listhead sizable="true">
							<listheader width="200px" label="name" sort="auto" />
							<listheader width="200px" label="gender" sort="auto" />
						</listhead>
						<listitem>
							<listcell label="Mary" />
							<listcell label="FEMALE" />
						</listitem>
						<listitem>
							<listcell label="John" />
							<listcell label="MALE" />
						</listitem>
						<listitem>
							<listcell label="Jane" />
							<listcell label="FEMALE" />
						</listitem>
						<listitem>
							<listcell label="Henry" />
							<listcell label="MALE" />
						</listitem>
					</listbox>
				</window>
				</zk>`,
	);
	let listboxWidth_cafe = await ClientFunction(() =>
		jq(".z-listbox").width(),
	)();
	let listitemWidth_cafe = await ClientFunction(() =>
		jq(".z-listitem:eq(0)").width(),
	)();
	await t.expect(listitemWidth_cafe > listboxWidth_cafe).ok();
});
