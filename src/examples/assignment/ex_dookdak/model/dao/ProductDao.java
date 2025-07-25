package examples.assignment.ex_dookdak.model.dao;

import examples.assignment.ex_dookdak.model.dto.ProductDto;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
    private ProductDao() { connect(); }
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance() {
        return instance;
    }
    private ArrayList<ProductDto> productList = new ArrayList<>();
    private Connection conn;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dookdak", "root", "1234");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addProduct(ProductDto dto) {
        PreparedStatement ps = null;
        try {
            String sql = "insert into product(pUser, pName, pDesc, pPrice, pPw) values (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getpUser());
            ps.setString(2, dto.getpName());
            ps.setString(3, dto.getpDesc());
            ps.setInt(4, dto.getpPrice());
            ps.setString(5, dto.getpPw());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<ProductDto> viewProduct() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int pId = rs.getInt("pId");
                String pUser = rs.getString("pUser");
                String pName = rs.getString("pName");
                int pPrice = rs.getInt("pPrice");
                boolean isSold = rs.getBoolean("isSold");
                String pDate = rs.getString("pDate");
                ProductDto list = new ProductDto(pId, pUser, pName, pPrice, isSold, pDate);
                productList.add(list);
            }
            return productList;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ProductDto viewProduct(int pid) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product where pid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            rs.next();
            int pId = rs.getInt("pId");
            String pUser = rs.getString("pUser");
            String pName = rs.getString("pName");
            int pPrice = rs.getInt("pPrice");
            boolean isSold = rs.getBoolean("isSold");
            String pDate = rs.getString("pDate");
            String pDesc = rs.getString("pDesc");
            return new ProductDto(pId, pPrice, pUser, pName, pDesc, null, pDate, isSold);
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean checkProduct(int pId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product where pId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getInt("pId") == pId) return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int checkProduct(int pId, String pPw) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product where pId = ? or pPw = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            ps.setString(2, pPw);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getInt("pId") == pId) {
                    if (rs.getString("pPw").equals(pPw)) {
                        return 0;
                    } else return 2;
                }
            }
            return 1;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateProduct(int pId) {
        PreparedStatement ps = null;
        try {
            String sql = "update product set isSold = true where pId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateProduct(ProductDto dto) {
        PreparedStatement ps = null;
        try {
            String sql = "update product set pName = ?, pDesc = ?, pPrice = ?, isSold = false where pId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getpName());
            ps.setString(2, dto.getpDesc());
            ps.setInt(3, dto.getpPrice());
            ps.setInt(4, dto.getpId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deleteProduct(int pId) {
        PreparedStatement ps = null;
        try {
            String sql = "delete from product where pId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<ProductDto> viewRanking() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select pUser, count(pUser) from product group by pUser order by count(pUser) desc limit 10";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String pUser = rs.getString("pUser");
                int count = rs.getInt("count(pUser)");

                ProductDto list = new ProductDto(pUser, count);
                productList.add(list);
            }
            return productList;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<ProductDto> searchProduct(String search) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product where pName like '%?%' or pDesc like '%?%'";
            ps = conn.prepareStatement(sql);
            ps.setString(1, search);
            ps.setString(2, search);
            rs = ps.executeQuery();

            if (!rs.next()) {
                productList.add(new ProductDto(-1, null, null, 0, false, null));
                return productList;
            }
            while (rs.next()) {
                int pId = rs.getInt("pId");
                String pUser = rs.getString("pUser");
                String pName = rs.getString("pName");
                int pPrice = rs.getInt("pPrice");
                boolean isSold = rs.getBoolean("isSold");
                String pDate = rs.getString("pDate");
                ProductDto list = new ProductDto(pId, pUser, pName, pPrice, isSold, pDate);
                productList.add(list);
            }
            return productList;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터 입력 중 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
