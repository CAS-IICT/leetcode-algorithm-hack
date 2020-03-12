<?php
class Solution
{
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */

    function twoSum($nums, $target)
    {
        foreach ($nums as $key => $value) {
            foreach ($nums as $key2 => $value2) {
                if ($key == $key2) continue;
                if ($value + $value2 == $target) return [$key, $key2];
            }
        }
        return null;
    }
}
$nums = [2, 7, 11, 15];
$target = 9;
$solution = new Solution();
$resuls = $solution->twoSum($nums, $target);
print_r($resuls);
