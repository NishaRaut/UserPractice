package com.bridgelabz.user.utility;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
@Component
public class UserToken {
	public final String TOKEN_SECRET="fundoo";
	
	public String generateToken(Long id) throws Exception
	{
		try {
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			String token=JWT.create()
							.withClaim("id", id)
							.sign(algorithm);
			return token;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("status.token.errorMessage");
		}
	}
	
	public Long tokenVerify(String token) throws Exception 
	{
		Long userid;
		try {
			Verification verification=JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
			JWTVerifier jwtverifier=verification.build();
			DecodedJWT decodedjwt=jwtverifier.verify(token);
			Claim claim=decodedjwt.getClaim("id");
			userid=claim.asLong();	
		}
		catch(Exception exception)
		{
			throw new Exception("Token Not Verified");
		}
		
		return userid;
}
}
