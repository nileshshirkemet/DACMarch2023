using Microsoft.AspNetCore.Razor.TagHelpers;

namespace BasicWebApp.TagHelpers;

[HtmlTargetElement("span", Attributes = "lotto-digit-count")]
public class LottoTagHelper : TagHelper
{
    private static Random rdm = new Random();

    public int LottoDigitCount { get; set; }

    public override void Process(TagHelperContext context, TagHelperOutput output)
    {
        var digits = new System.Text.StringBuilder();
        for(int i = 0; i < LottoDigitCount; ++i)
            digits.Append(rdm.Next(10));
        output.Content.SetContent(digits.ToString());
    }
}