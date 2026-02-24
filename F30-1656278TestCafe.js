import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F30-1656278TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F30-1656278TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:h2>[ 1656278 ] Menuitem enabled/disabled support</n:h2>
			<n:ol>
				<n:li>click "File" then you will see the "Open" item to be disabled and cannot be clicked</n:li>
		                <n:li>Try to enable it and click on it, it should show alert message</n:li>
			</n:ol>
			<menubar id="menubar">
				<menu id="menu" label="File">
					<menupopup>
						<menuitem label="New" autocheck="true" />
						<menuitem id="menuitem" label="Open" autocheck="true"
							onClick="alert(self.label)" disabled="true" />
						<menuitem label="Save" />
						<menuseparator />
		                                <menuitem id="menuitem1" label="Disable Open" onClick="open.disabled=true"/>
		                                <menuitem label="Enable Open" onClick="open.disabled=false"/>
						<menuitem label="Exit" />
					</menupopup>
				</menu>
				<menu id="menu2" label="Help">
					<menupopup>
						<menuitem label="Index" />
						<menu id="menu3" label="About">
							<menupopup>
								<menuitem id="menuitem2" disabled="true" label="About ZK"
									onClick="alert(self.label)" />
								<menuitem label="About Potix" onClick="alert(self.label)" />
							</menupopup>
						</menu>
					</menupopup>
				</menu>
			</menubar>
		</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
	await t
		.click(Selector(() => zk.Desktop._dt.$f("menu", true).$n()))
		.click(Selector(() => zk.Desktop._dt.$f("menuitem", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
	await t
		.click(Selector(() => zk.Desktop._dt.$f("menuitem1", true).$n()))
		.click(Selector(() => zk.Desktop._dt.$f("menu2", true).$n()))
		.click(Selector(() => zk.Desktop._dt.$f("menu3", true).$n()))
		.click(Selector(() => zk.Desktop._dt.$f("menuitem2", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("menuitem2", true).nextSibling.$n()),
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).ok();
});
