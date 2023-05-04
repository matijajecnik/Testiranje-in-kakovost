package ltpo.Seznami;

import java.util.Scanner;

public class SeznamiUV {

    private Sklad<String> sklad;

    private PrioritetnaVrsta<String> vrsta;
    public SeznamiUV() {
        sklad = new Sklad<>();
        vrsta = new PrioritetnaVrsta<>();
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK", tmp;
        switch (token) {
            case "s_add":
                if (sc.hasNext()) {
                    tmp = sc.next();
                    if (tmp.startsWith("\"")) {
                        tmp = tmp.substring(1);
                        while (sc.hasNext()) {
                            //tmp1=sc.next();

                            tmp = tmp + " " + sc.next();
                            if (tmp.endsWith("\"")) {
                                break;
                            }
                        }
                        if (tmp.endsWith("\"")) {
                            tmp = tmp.substring(0, tmp.length() - 1);
                        } else {
                            result = "Error: please specify a correct string";
                            break;
                        }
                    }
                    sklad.push(tmp);
                } else {
                    result = "Error: please specify a string";
                }
                break;

            case "s_removeFirst":
                if (!sklad.isEmpty()) {
                    result = sklad.pop();
                } else {
                    result = "Error: stack is empty";
                }
                break;

            case "s_reset":
                while (!sklad.isEmpty()) {
                    sklad.pop();
                }
                break;

            case "s_size":
                result = String.format("%d", sklad.size());
                break;

            case "s_isTop":
                if (sc.hasNext()) {
                    tmp = sc.next();
                    if (tmp.startsWith("\"")) {
                        tmp = tmp.substring(1);
                        while (sc.hasNext()) {
                            //tmp1=sc.next();

                            tmp = tmp + " " + sc.next();
                            if (tmp.endsWith("\"")) {
                                break;
                            }
                        }
                        if (tmp.endsWith("\"")) {
                            tmp = tmp.substring(0, tmp.length() - 1);
                        } else {
                            result = "Error: please specify a correct string";
                            break;
                        }
                    }
                    if (!sklad.isEmpty()) {
                        if (sklad.isTop(tmp)) {
                            result = "OK";
                        } else {
                            result = "Error: wrong element";
                        }

                    } else {
                        result = "Error: stack is empty";
                    }
                } else {
                    result = "Error: please specify a string";
                }
                break;

            case "s_search":
                if (sc.hasNext()) {
                    tmp = sc.next();
                    if (tmp.startsWith("\"")) {
                        tmp = tmp.substring(1);
                        while (sc.hasNext()) {
                            //tmp1=sc.next();

                            tmp = tmp + " " + sc.next();
                            if (tmp.endsWith("\"")) {
                                break;
                            }
                        }
                        if (tmp.endsWith("\"")) {
                            tmp = tmp.substring(0, tmp.length() - 1);
                        } else {
                            result = "Error: please specify a correct string";
                            break;
                        }
                    }
                    result = String.format("%d", sklad.search(tmp));
                } else {
                    result = "Error: please specify a string";
                }
                break;
            case "pq_add": // brez elementov z več nizi “"
                if (sc.hasNext()) {
                    String val = sc.next();
                    vrsta.add(val);
                }
                else
                    result = "Error: please specify a string";
                break;
            case "pq_remove_first":
                if (!vrsta.isEmpty())
                    result = vrsta.removeFirst();
                else
                    result = "Error: priority queue is empty";
                break;
            case "pq_get_first":
                if (!vrsta.isEmpty())
                    result = vrsta.getFirst();
                else
                    result = "Error: priority queue is empty";
                break;
            case "pq_depth":
                result = String.valueOf(vrsta.depth());
                break;
            case "pq_isEmpty":
                result = (vrsta.isEmpty() ? "Priority queue is empty" : "Priority queue is not empty");
                break;
            case "pq_size":
                result = String.valueOf(vrsta.size());
                break;
            default:
                break;
        }
        return result;
    }
}
