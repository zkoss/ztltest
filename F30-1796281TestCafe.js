import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F30-1796281TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F30-1796281TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>[ 1796281 ] Improve Working with Combobox. Both setSelectedItem(Comboitem item) and setSelectedIndex(int jsel) are
			supported.</n:p>
				<n:ol>
					<n:li>click selectedItem , then combobox will sets the selectItem to "Cool!"</n:li>
					<n:li>click selectedIndex, then combobox will sets the selectItem to "Thumbs Up!"</n:li>
				</n:ol>
				<combobox id="cbbox">
					<comboitem label="Apple" />
					<comboitem label="Grape" />
					<comboitem id="c" label="Cool!" />
					<comboitem label="Simple and Rich" />
					<comboitem label="Thumbs Up!" />
				</combobox>
				<button id="btn1" label="selectedItem = Cool!" onClick="cbbox.selectedItem = c"/>
				<button id="btn2" label="selectedIndex = 4" onClick="cbbox.selectedIndex = 4"/>
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("cbbox", true).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("cbbox", true).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("Cool!"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("cbbox", true).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("Thumbs Up!"));
});
