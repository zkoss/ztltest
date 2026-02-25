import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-2028TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-2028TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Chosenbox Deletion with ListSubModel" border="normal" width="500px" height="200px">
	<zscript><![CDATA[
		import java.util.ArrayList;
		import org.zkoss.zul.*;
		ArrayList list = new ArrayList();
		list.add("apple");
		list.add("book");
		list.add("cake");
		list.add("ding");
		ListSubModel model = ListModels.toListSubModel(new ListModelList(list));
	]]></zscript>
	<label multiline="true">
		1. Choose "book", "apple", "cake".
		2. Delete "cake"
		3. "book" and "apple" should still be selected.
	</label>
	<separator/>
	<chosenbox id="cb" width="300px" model="\${model}"/>
</window>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("inp"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n("inp")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("b o o k");
	await ztl.waitResponse(t);
	await t.wait(200).pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(200);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("inp"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n("inp")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("a p p l e");
	await ztl.waitResponse(t);
	await t.wait(200).pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(200);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("inp"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n("inp")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("c a k e");
	await ztl.waitResponse(t);
	await t.wait(200).pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(
			Selector(
				() =>
					jq(
						".z-chosenbox-item:contains(cake) .z-chosenbox-delete",
					)[0],
			),
		);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-chosenbox-item:contains(apple)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq(".z-chosenbox-item:contains(book)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0 && verifyVariable_cafe_1_1)
		.ok("'book' and 'apple' should still be selected.");
});
