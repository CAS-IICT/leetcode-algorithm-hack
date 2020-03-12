<?php
class Solution
{
    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s)
    {
        $chars = "";
        $i = 0;
        $max = 0;
        while ($i < strlen($s)) {
            $pos = strpos($chars, $s[$i]);
            if ($pos === false) {
                $chars .= $s[$i++];
                $max = strlen($chars) > $max ? strlen($chars) : $max;
            } else {
                $chars = substr($chars, $pos + 1);
            }
        }
        return $max;
    }
}

for($i=1;$i<count($argv);$i++){
    echo (new Solution())->lengthOfLongestSubstring($argv[$i]);
    echo "\n";
}
