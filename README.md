# Splitwise
My implementation of Splitwise

1. Takes each member's contribution into first map.
2. Takes average of contributions. Subtracts each contribution in the map from the average and adds result into second map w.r.t each member.
3. From the new second map, given amt and received amt (MAX and MIN values) are added to give result.
4. If result is less than zero then second map is updated to set MIN value is result. If result is greater than or equal to 0, then then map is updated to set MAX value as result. 

                                if (result >= 0) {
                                  map.put(MAX_KEY, result);
                                  map.put(MIN_KEY, 0.0);
                                } else {
                                  map.put(MIN_KEY, result);
                                  map.put(MAX_KEY, 0.0);
                                }
