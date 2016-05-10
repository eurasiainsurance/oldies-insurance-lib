package kz.theeurasia.policy.services.inject;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {
    public static <T> List<T> toList(T[] s) {
	List<T> t = new ArrayList<>(s.length);
	for (T e : s)
	    t.add(e);
	return t;
    }

}
