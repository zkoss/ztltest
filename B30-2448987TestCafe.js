import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2448987TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2448987TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page id="testZul" title=" New ZUL Title" cacheable="false" 
				language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
			<window>
			<html><![CDATA[  
			<ol>
			<li>You shall see the listbox in the order of item4,item0,item1,item2,item3,item5,item6,item7,item8,item9</li>
			<li>Otherwise, it is a bug</li>
			<li>Done</li>
			</ol>
			]]>
			
			</html>
			<zscript><![CDATA[
			    ListModelList model = new ListModelList(new ArrayList(10), true);
			    for (int j = 0; j < 10; ++j) {
			    	model.add("item"+j);
			    }
			    List subList = model.subList(0, 5);
			    Collections.rotate(subList, +1);
			]]></zscript>
				<listbox model="\${model}"/>
			</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(3)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(5)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(6)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(7)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item7"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(8)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item8"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:eq(9)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("item9"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listitem").length)(),
			),
		)
		.eql(ztl.normalizeText("10"));
});
