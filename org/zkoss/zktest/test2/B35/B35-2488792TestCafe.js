import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2488792TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2488792TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<button onClick="dg.open = !dg.open" label="Click Me, if no error, that is correct!"/>
	<grid>
		<columns sizable="true">
			<column label="Brand" />
			<column label="Processor Type" width="150px"/>
			<column label="Memory (RAM)" width="120px"/>
			<column label="Price"  width="100px"/>
			<column label="Hard Drive Capacity" width="150px"/>
		</columns>
		<rows>
			<group label="Dell" id="dg"/>
			<row>
				<label style="padding-left:15px" value="Dell E4500 2.2GHz"/>
				<label value="Intel Core 2 Duo"/>
				<label value="2GB RAM"/>
				<label value="$261.00" style="color:green"/>
				<label value="500GB"/>
			</row>
			<row>
				<label style="padding-left:15px" value="XP-Pro Slim Dell-Inspiron-530-s"/>
				<label value="Intel Core 2 Duo"/>
				<label value="2GB RAM"/>
				<label value="$498.93" style="color:green"/>
				<label value="500GB"/>				
			</row>
			<row>
				<label style="padding-left:15px" value="Dell P4 3.2 GHz"/>
				<label value="Intel Pentium 4"/>
				<label value="4GB RAM"/>
				<label value="$377.99" style="color:green"/>
				<label value="500GB"/>				
			</row>
		</rows>
	</grid>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
