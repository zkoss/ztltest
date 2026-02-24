import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1836257TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1836257TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="listbox demo" border="normal">
                [ 1836257 ] Click the Button. The stripe color should be correct.
                <listbox width="250px">
                    <listhead sizable="true">
                        <listheader label="name" sort="auto"/>
                        <listheader label="gender" sort="auto"/>
                    </listhead>
                    <listitem>
                        <listcell label="Mary"/>
                        <listcell label="FEMALE"/>
                    </listitem>
                    <listitem id="row1">
                        <listcell label="John"/>
                        <listcell label="MALE"/>
                    </listitem>
                    <listitem>
                        <listcell label="Jane"/>
                        <listcell label="FEMALE"/>
                    </listitem>
                    <listitem >
                        <listcell label="Henry"/>
                        <listcell label="MALE"/>
                    </listitem>
                </listbox>
                <button label="change" onClick=\'row1.visible = !row1.visible\'/>
            </window>`,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(0)").hasClass("z-listbox-odd"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(1)").hasClass("z-listbox-odd"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(2)").hasClass("z-listbox-odd"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(3)").hasClass("z-listbox-odd"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$row1").is(":visible"))())
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(0)").hasClass("z-listbox-odd"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(1)").hasClass("z-listbox-odd"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(3)").hasClass("z-listbox-odd"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$row1").is(":visible"))())
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(0)").hasClass("z-listbox-odd"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(1)").hasClass("z-listbox-odd"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(2)").hasClass("z-listbox-odd"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listitem:eq(3)").hasClass("z-listbox-odd"),
			)(),
		)
		.ok();
});
