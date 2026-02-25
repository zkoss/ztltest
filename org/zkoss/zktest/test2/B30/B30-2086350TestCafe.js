import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2086350TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2086350TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Please click the "Click Me!" header of the nested listbox, and then no error appears.(That is correct)
<listbox width="400px" onSelect=\'alert(self.selectedItem.uuid);\'>
	<listhead sizable="true">
		<listheader label="name" sort="auto" />
		<listheader label="gender" sort="auto" />
	</listhead>
	<listitem>
		<listcell>
			<listbox width="250px">
				<listhead sizable="true">
					<listheader id="lh" label="Click Me!" sort="auto" />
					<listheader label="gender" sort="auto" />
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

		</listcell>
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
</zk>`,
	);
	await t.click(Selector(() => jq("$lh")[0]));
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
