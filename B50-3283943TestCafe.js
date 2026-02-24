import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3283943TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3283943TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w="client">
				<html><![CDATA[
					<ol>
						<li>Click on Groups and Listgroups, if the UUIDs shown below are different, it is a bug.</li>
					</ol>
				]]></html>
				<grid>
					<rows>
						<group id="group1" onClick="lb1s.value = self.group.uuid">
							<attribute w:name="onClick"><![CDATA[
								var g = this.getGroup(),
									id = g ? g.uuid : \'null\';
								this.$f(\'lb1c\').setValue(id);
							]]></attribute>
							Group 1 (click to show getGroup() result)
						</group>
						<row>Row 1-1</row>
						<row>Row 1-2</row>
						<group id="group2" onClick="lb1s.value = self.group.uuid">
							<attribute w:name="onClick"><![CDATA[
								var g = this.getGroup(),
									id = g ? g.uuid : \'null\';
								this.$f(\'lb1c\').setValue(id);
							]]></attribute>
							Group 2 (click to show getGroup() result)
						</group>
						<row>Row 2-1</row>
						<row>Row 2-2</row>
						<group id="group3" onClick="lb1s.value = self.group.uuid">
							<attribute w:name="onClick"><![CDATA[
								var g = this.getGroup(),
									id = g ? g.uuid : \'null\';
								this.$f(\'lb1c\').setValue(id);
							]]></attribute>
							Group 3 (click to show getGroup() result)
						</group>
						<row>Row 3-1</row>
						<row>Row 3-2</row>
					</rows>
				</grid>
				<div>
					getGroup uuid (server): <label id="lb1s" />
				</div>
				<div>
					getGroup uuid (client): <label id="lb1c" />
				</div>
				<separator />
				<listbox onSelect="lb2s.value = self.selectedItem.listgroup.uuid">
					<attribute w:name="onSelect"><![CDATA[
						var g = this.getSelectedItem().getListgroup(),
							id = g ? g.uuid : \'null\';
						this.$f(\'lb2c\').setValue(id);
					]]></attribute>
					<listgroup><listcell>Listgroup 1</listcell></listgroup>
					<listitem id="li1"><listcell>Listitem 1-1</listcell></listitem>
					<listitem><listcell>Listitem 1-2</listcell></listitem>
					<listgroup><listcell>Listgroup 2</listcell></listgroup>
					<listitem id="li2"><listcell>Listitem 2-1</listcell></listitem>
					<listitem><listcell>Listitem 2-2</listcell></listitem>
					<listgroup><listcell>Listgroup 3</listcell></listgroup>
					<listitem id="li3"><listcell>Listitem 3-1</listcell></listitem>
					<listitem><listcell>Listitem 3-2</listcell></listitem>
				</listbox>
				<div>
					getListgroup uuid (server): <label id="lb2s" />
				</div>
				<div>
					getListgroup uuid (client): <label id="lb2c" />
				</div>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("group1", true).$n()),
		{ offsetX: 10, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1c", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1s", true).$n().innerHTML,
				)(),
			),
		);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("group2", true).$n()),
		{ offsetX: 10, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1c", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1s", true).$n().innerHTML,
				)(),
			),
		);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("group3", true).$n()),
		{ offsetX: 10, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1c", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb1s", true).$n().innerHTML,
				)(),
			),
		);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("li1", true).$n()),
		{ offsetX: 10, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2c", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2s", true).$n().innerHTML,
				)(),
			),
		);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("li2", true).$n()),
		{ offsetX: 10, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2c", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2s", true).$n().innerHTML,
				)(),
			),
		);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("li3", true).$n()),
		{ offsetX: 10, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2c", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2s", true).$n().innerHTML,
				)(),
			),
		);
});
