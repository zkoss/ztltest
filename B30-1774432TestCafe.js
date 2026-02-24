import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1774432TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1774432TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
		<html><![CDATA[
		To reproduce the bug:
		<ol>
		<li>Select "Item 2"</li>
		<li>Click remove</li>
		<li>Click append</li>
		<li>"Item 3" is appended</li>
		<li>Click append</li>
		<li>"Item 4" is appended</li>
		<li>Click append</li>
		</ol>
		Error Message:
		"Failed to invoke zkTree.setAttr\n		el has no properties". And, it shall not appear.
		]]></html>
		<tree id="t" mold="paging" pageSize="3">
			<treechildren id="tc">
						<treeitem>
										<treerow >
											<treecell label="Item 1"/>
										</treerow>
						</treeitem>
						<treeitem>
										<treerow >
											<treecell id="item2" label="Item 2"/>
										</treerow>
						</treeitem>
			</treechildren>
		</tree>
		<zscript>
			int count =2;
			public void append() {
				count++;
				Treeitem ti = new Treeitem("Item "+count);
				Treechildren tc = t.getTreechildren();
				ti.setParent(tc);
			}
			public void remove() {
				Treeitem ti = t.getSelectedItem();
				if (ti != null) ti.detach();
				else alert("You have to select an item first");
			}
			public void removeLast() {
				List kids = t.getTreechildren().getChildren();
				if (!kids.isEmpty())
					kids.get(kids.size() - 1).detach();
			}
		</zscript>
		<button id="append" label="append" onClick="append()"/>
		<button id="remove" label="remove" onClick="remove()"/>
		<button id="removelast" label="remove last" onClick="removeLast()"/>
		<button id="redraw" label="redraw" onClick="t.invalidate()"/>
		</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("item2", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("remove", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("item2", true) &&
					!!zk.Desktop._dt.$f("item2", true).$n(),
			)(),
		)
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("append", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tc", true).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				parseInt(
					await ClientFunction(
						() =>
							zk.Desktop._dt.$f("t", true).$n("rows").rows.length,
					)(),
				),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("append", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tc", true).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				parseInt(
					await ClientFunction(
						() =>
							zk.Desktop._dt.$f("t", true).$n("rows").rows.length,
					)(),
				),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("append", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true).paging).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("removelast", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("removelast", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tc", true).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				parseInt(
					await ClientFunction(
						() =>
							zk.Desktop._dt.$f("t", true).$n("rows").rows.length,
					)(),
				),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true).paging).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("redraw", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				parseInt(
					await ClientFunction(
						() =>
							zk.Desktop._dt.$f("t", true).$n("rows").rows.length,
					)(),
				),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true).paging).is(":visible"),
			)(),
		)
		.notOk();
});
