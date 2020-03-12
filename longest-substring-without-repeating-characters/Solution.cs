using System;
public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        var chars = "";
        var i = 0;
        var max = 0;
        while (i < s.Length)
        {
            var index = chars.IndexOf(s[i]);
            if (index == -1)
            {
                chars += s[i++];
                max = max > chars.Length ? max : chars.Length;
            }
            else chars = chars.Substring(index + 1);
        }
        return max;
    }
    public static void Main(string[] args)
    {
        for (var i = 0; i < args.Length; i++)
        {
            var solution = new Solution();
            var res = solution.LengthOfLongestSubstring(args[i]);
            Console.WriteLine(res);
        }
    }
}
